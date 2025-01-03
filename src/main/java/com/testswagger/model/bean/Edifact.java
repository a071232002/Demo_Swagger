package com.testswagger.model.bean;

import com.testswagger.model.bean.element.UNA;
import com.testswagger.model.bean.element.UNB;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edifact implements Serializable {
    private UNA una;
    private UNB unb;
    private UNH unh;
    private MSG msg;
    private ORG org;
    private SRC src;

    private RCI rci;
    private DAT dat;


}
