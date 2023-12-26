package com.example.recentbatch.core;

import com.example.recentbatch.core.domain.PlainText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PlainTextItemProcessor implements ItemProcessor<PlainText, PlainText> {
    private static final Logger log = LoggerFactory.getLogger(PlainTextItemProcessor.class);

    @Override
    public PlainText process(final PlainText plainText) {
//        final Long id = plainText.getId();
        final String transformedPlainText = plainText.getText() + ": transformed";
        log.info("Converting (" + plainText + ") into (" + transformedPlainText + ")");

        return PlainText.of(transformedPlainText);
    }

}
