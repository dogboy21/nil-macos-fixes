package io.dogboy.nilmacosfixes;

import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

public class NilMacosFixes implements Runnable {
    public static final NilLogger log = NilLogger.get("NilMacosFixes");

    @Override
    public void run() {
        log.info("Initializing NilMacosFixes...");
        ModRemapper.setTargetMapping("default");

        ClassTransformer.register(new LWCToolkitTransformer());
        ClassTransformer.register(new CPlatformWindowTransformer());
    }

}