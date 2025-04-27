package io.dogboy.nilmacosfixes;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("sun.lwawt.macosx.CPlatformWindow")
public class CPlatformWindowTransformer extends MiniTransformer {
	@Patch.Method("deliverMoveResizeEvent(IIIIZ)V")
	public void patch(PatchContext ctx) {
		NilMacosFixes.log.info("Patching CPlatformWindow.deliverMoveResizeEvent");

		ctx.search(INVOKEVIRTUAL("sun/lwawt/macosx/CPlatformWindow", "flushBuffers", "()V")).jumpBefore();
		ctx.add(RETURN());
	}
}
