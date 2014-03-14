/* Copyright (C) AtomGamers - (AG152) Change Item Display Name
 * APIs: CraftBukkit 1.5.2-R0.1
 * Autor(Author): AtomGamers
 * Classe Main: Gerenciamento/Tratamento de dados uteis.
 */
package br.AtomGamers.cidn;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    
    @Override
    public void onEnable()
    {
        File file = new File(getDataFolder(), "config.yml");
        if(!file.exists())
        {
            try{
                saveResource("config_template.yml", false);
                File config2 = new File(getDataFolder(), "config_template.yml");
                config2.renameTo(new File(getDataFolder(), "config.yml"));
            }catch(Exception e){
                
            }
        }
        reloadConfig();
        ConsoleCommandSender sender = Bukkit.getConsoleSender();
        getCommand("itemname").setExecutor(new ItemName());
        getCommand("itemdesc").setExecutor(new ItemDescription());
        sender.sendMessage("§f[§bChange Item Display Name§f] Plugin inicializado. (Autor=AtomGamers)");
    }
    
    @Override
    public void onDisable()
    {
        ConsoleCommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage("§f[§8Change Item Display Name§f] Plugin finalizado. (Autor=AtomGamers)");
    }
}