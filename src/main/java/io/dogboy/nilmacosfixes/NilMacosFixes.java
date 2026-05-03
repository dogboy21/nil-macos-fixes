package io.dogboy.nilmacosfixes;

import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

import java.util.Locale;

public class NilMacosFixes implements Runnable {
    public static final NilLogger log = NilLogger.get("NilMacosFixes");

    @Override
    public void run() {
        if (!System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("mac")) {
            log.info("Game was not launched on macOS, disabling NilMacosFixes");
            return;
        }

        log.info("Initializing NilMacosFixes...");
        ModRemapper.setTargetMapping("default");

        ClassTransformer.register(new LWCToolkitTransformer());
        ClassTransformer.register(new CPlatformWindowTransformer());
    }

}