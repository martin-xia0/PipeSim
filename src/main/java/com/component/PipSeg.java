package com.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PipSeg {
    private static Log logger = LogFactory.getLog(PipSeg.class);
    private PipSeg(double pipLen, double pipDiameter) {
        logger.info(String.format("创建直管段 %s m, 直径 %d m", pipLen, pipDiameter));
    }

    public static double headLoss() {
        // 水头损失
        double loss = 0.0;
        return loss;
    }
    
}
