package io.github.natainakata.clayium.util;

import io.github.natainakata.clayium.Clayium;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  お借りしました https://github.com/RiSE4/NaturalStyle2/blob/1.12.2/src/main/java/rise/naturalstyle/util/LogHelper.java
 */
public class LogHelper {
    private static Logger logger;

    public static void load() {
        logger = LogManager.getLogger(Clayium.MOD_NAME);
    }

    public static void debugLog(String log)
    {
        log(log, Level.DEBUG);
    }

    public static void debugInfoLog(String log)
    {
        log(log, Level.INFO);
    }

    public static void debugTrace(String log)
    {
        log(log, Level.TRACE);
    }

    public static void warnLog(String log)
    {
        log(log, Level.WARN);
    }

    private static void log(String log, Level level)
    {
        // if(NaturalConfig.DEBUG_MODE)
        logger.log(level, log);
    }
}
