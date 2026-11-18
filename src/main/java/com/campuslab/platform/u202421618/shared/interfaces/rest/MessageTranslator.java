package com.campuslab.platform.u202421618.shared.interfaces.rest;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class MessageTranslator {
    private final MessageSource source;

    public MessageTranslator(MessageSource source) { this.source = source; }

    public String get(String key, Locale locale) {
        Locale supported = locale != null && "es".equals(locale.getLanguage())
                ? Locale.forLanguageTag("es") : Locale.ENGLISH;
        return source.getMessage("error." + key, null, "An unexpected error occurred.", supported);
    }
}
