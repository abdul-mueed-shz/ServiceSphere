package com.abdul.ecommerce.email.service;

import com.abdul.ecommerce.email.enums.EmailTemplates;
import com.abdul.toolkit.utils.product.info.ProductPurchaseResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
@Service
public class EmailService {

    @Qualifier("mailDevSender")
    private final JavaMailSender mailSender;

    private final SpringTemplateEngine templateEngine;

    public EmailService(@Qualifier("mailDevSender") JavaMailSender mailSender, SpringTemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendPaymentConfirmationEmail(
            String destinationEmail,
            String customerName,
            Integer orderId,
            BigDecimal amount)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        messageHelper.setFrom("abdulmueedshahbaz@gmail.com");

        final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> contextMap = new HashMap<>();
        contextMap.put("customerName", customerName);
        contextMap.put("orderId", orderId);
        contextMap.put("amount", amount);

        Context context = new Context();
        context.setVariables(contextMap);

        try {
            messageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());
            messageHelper.setText(templateEngine.process(templateName, context), true);
            messageHelper.setTo(destinationEmail);

            mailSender.send(mimeMessage);
            log.info("Payment Confirmation Email sent to {} with template {}", destinationEmail, templateName);
        } catch (MessagingException e) {
            log.error("Unable to send Payment Confirmation Email to {} with template {} ", destinationEmail,
                    templateName);
            log.error(e.getMessage(), e);
        }
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            String orderReference,
            BigDecimal amount,
            List<ProductPurchaseResponse> productPurchaseResponseList)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        messageHelper.setFrom("abdulmueedshahbaz@gmail.com");

        final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

        Map<String, Object> contextMap = new HashMap<>();
        contextMap.put("customerName", customerName);
        contextMap.put("orderReference", orderReference);
        contextMap.put("amount", amount);
        contextMap.put("products", productPurchaseResponseList);

        Context context = new Context();
        context.setVariables(contextMap);

        try {
            messageHelper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());
            messageHelper.setText(templateEngine.process(templateName, context), true);
            messageHelper.setTo(destinationEmail);

            mailSender.send(mimeMessage);
            log.info("Email sent to {} with template {}", destinationEmail, templateName);
        } catch (MessagingException e) {
            log.error("Unable to send email to {} with template {} ", destinationEmail, templateName);
            log.error(e.getMessage(), e);
        }
    }
}
