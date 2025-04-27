package io.dogboy.nilmacosfixes;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("sun.lwawt.macosx.LWCToolkit")
public class LWCToolkitTransformer extends MiniTransformer {
	@Patch.Method("getPlatformWindowUnderMouse()Lsun/lwawt/PlatformWindow;")
	public void patch(PatchContext ctx) {
		NilMacosFixes.log.info("Patching LWCToolkit.getPlatformWindowUnderMouse");

		ctx.jumpToStart();
		ctx.add(
				ACONST_NULL(),
				ARETURN()
		);
	}
}
