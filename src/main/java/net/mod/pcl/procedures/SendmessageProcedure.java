package net.mod.pcl.procedures;

import net.mod.pcl.PclModElements;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

@PclModElements.ModElement.Tag
public class SendmessageProcedure extends PclModElements.ModElement {
	public SendmessageProcedure(PclModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				System.err.println("Failed to load dependency guistate for procedure Sendmessage!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent((new Object() {
					public String getText() {
						TextFieldWidget textField = (TextFieldWidget) guistate.get("text:awa");
						if (textField != null) {
							return textField.getText();
						}
						return "";
					}
				}.getText())));
		}
	}
}
