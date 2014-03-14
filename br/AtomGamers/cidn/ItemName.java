/* Copyright (C) AtomGamers - (AG152) Change Item Display Name
 * APIs: CraftBukkit 1.5.2-R0.1
 * Autor(Author): AtomGamers
 * Classe Comandos: Gerenciamento/Tratamento dos comandos.
 */
package br.AtomGamers.cidn;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemName implements CommandExecutor{
    
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
                        sender.sendMessage("§b[Itens] §fUse /itemname <nome desejado>");
                    }
                    else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                    {
                        sender.sendMessage("§b[Itens] §fUse /itemname <desired name>");
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
                            sender.sendMessage("§b[Itens] §cYou can not rename air!");
                        }
                    }else{
                        ItemMeta Hand = Meta.getItemMeta();
                        String display = "";
                        for(String m : args)
                        {
                            display+=m+" ";
                        }
                        display=display.replaceAll("&", "§");
                        Hand.setDisplayName(display);
                        Meta.setItemMeta(Hand);
                        if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("br"))
                        {
                            sender.sendMessage("§b[Itens] §fO Nome do item foi modificado.");
                            sender.sendMessage("§b[Itens] §cNovo nome: "+display);
                        }
                        else if(plugin.getConfig().getString("Linguagem").equalsIgnoreCase("en"))
                        {
                            sender.sendMessage("§6[Itens] §eThe name of the item was modified!");
                            sender.sendMessage("§6[Itens] §eNew item name: "+display);
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
