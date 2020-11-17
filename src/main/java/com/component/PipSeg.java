package com.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PipeSeg {
    private static Log logger = LogFactory.getLog(PipeSeg.class);
    private PipeSeg(double PipeLen, double PipeDiameter) {
        logger.info(String.format("创建直管段 %s m, 直径 %d m", PipeLen, PipeDiameter));
    }

    public static double headLoss() {
        // 水头损失
        double loss = 0.0;
        return loss;
    }
    
}
