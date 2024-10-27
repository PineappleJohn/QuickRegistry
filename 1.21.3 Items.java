public static Item registerItem(String id, String name) { //found this from more ores fabric 1.21
        Identifier iD = Identifier.of(Testmod.MOD_ID, id);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, iD);

        Item.Settings settings = new Item.Settings().registryKey(key).translationKey(name);
        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

public static void initialize() {
        Item[] customItems = {
                registerItem("id", "name"),
        };

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register(entries -> {
                    entries.add(customItems[0]);
                });

    }
