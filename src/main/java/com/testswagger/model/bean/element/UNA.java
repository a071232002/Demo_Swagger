package com.testswagger.model.bean.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * SERVICE STRING ADVICE (Default Service Characters)
 *
 * @: Component Data Element Separator
 * @+ Data Element Separator
 * @.or, Decimal Mark
 * @? Release Character
 * @* Repetition Separator. Not used.
 * @‘ Segment Terminator
 **/
@Data
@Builder
@AllArgsConstructor
public class UNA {

    private String componentDataElementSeparator;

    private String dataElementSeparator;

    private String decimalMark;

    private String releaseCharacter;

    private String repetitionSeparator;

    private String segmentTerminator;

    public UNA(){
        componentDataElementSeparator = ":";
        dataElementSeparator = "+";
        decimalMark = ".";
        releaseCharacter = "?";
        repetitionSeparator = "*";
        segmentTerminator = "'";
    }

    @Override
    public String toString() {
        return "UNA" + componentDataElementSeparator + dataElementSeparator + decimalMark + repetitionSeparator + segmentTerminator;
    }
}
