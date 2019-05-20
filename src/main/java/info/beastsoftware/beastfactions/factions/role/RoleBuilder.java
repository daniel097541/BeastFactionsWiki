package info.beastsoftware.beastfactions.factions.role;

import info.beastsoftware.beastfactions.BeastFactions;
import info.beastsoftware.beastfactions.factions.entity.IFactionRole;
import info.beastsoftware.beastfactions.factions.entity.IPermission;
import info.beastsoftware.beastfactions.factions.entity.impl.FactionRole;
import info.beastsoftware.beastfactions.injection.annotations.MainConfiguration;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import config.IConfig;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RoleBuilder implements IRoleBuilder {

    @Inject
    @MainConfiguration
    private IConfig mainConfig;


    @Override
    public IFactionRole createRole(String name, String displayName, List<IPermission> permissions, boolean defaultRole, int priority) {
        return new FactionRole(name, displayName, permissions, defaultRole, priority);
    }

    @Override
    public List<IFactionRole> createDefaultRoles() {

        String path = "Configuration.Factions.default-faction-roles";
        List<IFactionRole> roles = new ArrayList<>();
        YamlConfiguration configuration = mainConfig.getConfig();

        for (String section : configuration.getConfigurationSection(path).getKeys(false)) {

            String displayName = configuration.getString(path + "." + section + ".display-name");
            List<IPermission> perms = new ArrayList<>();
            for (String perm : configuration.getStringList(path + "." + section + ".permissions"))
                perms.add(BeastFactions.getInstance().getInternalApi().getPermission(perm));
            boolean defaultRole = configuration.getBoolean(path + "." + section + ".default");
            int priority = configuration.getInt(path + "." + section + ".priority");
            roles.add(createRole(section, displayName, perms, defaultRole, priority));
        }

        return roles;
    }
}
