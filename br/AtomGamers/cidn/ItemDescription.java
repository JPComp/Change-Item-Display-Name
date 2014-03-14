package br.AtomGamers.cidn;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDescription implements CommandExecutor{
    
    public Main plugin;
    
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String string, String[] args)
    {
        Player sender = (Player)cs;
        
        if(cmd.getName().equalsIgnoreCase("itemname"))
        {
            if(sender.hasPermission("itemname.name.change"))
            {
                if(args.length==0)
                {
                    if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("br"))
                    {
                        sender.sendMessage("§b[Itens] §fUse /itemdesc <descrição desejada>");
                    }
                    else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                    {
                        sender.sendMessage("§b[Itens] §fUse /itemdesc <desired description>");
                    }
                        
                }
                else if(args.length>0)
                {
                    ItemStack Meta = sender.getItemInHand();
                    if(Meta.getType() == Material.AIR)
                    {
                        if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("br"))
                        {
                            sender.sendMessage("§b[Itens] §cVocê não pode renomear ar!");
                        }
                        else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                        {
                            sender.sendMessage("§b[Itens] §cYou can not add description to air!");
                        }
                    }else{
                        ItemMeta Hand = Meta.getItemMeta();
                        String display = "";
                        for(String m : args)
                        {
                            display+=m+" ";
                        }
                        display=display.replaceAll("&", "§");
                        Hand.setLore(Arrays.asList(new String[] { display }));
                        Meta.setItemMeta(Hand);
                        if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("br"))
                        {
                            sender.sendMessage("§b[Itens] §fA descrição do item foi modificada.");
                            sender.sendMessage("§b[Itens] §cNova descrição: "+display);
                        }
                        else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                        {
                            sender.sendMessage("§6[Itens] §eThe description of the item was modified!");
                            sender.sendMessage("§6[Itens] §eNew item description: "+display);
                        }
                    }
                }
            }else{
                if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("br"))
                {
                    sender.sendMessage("§6[Itens] §cVocê não está autorizado(a)");
                }
                else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                {
                    sender.sendMessage("§6[Itens] §cYou are not allowed to use this because you don't have permissions!");
                }
            }
        }
        return false;
    }
}
