public static Block register(Block block, String ID, boolean shouldRegisterItem, String name) {
        Identifier id = Identifier.of(Testmod.MOD_ID, ID);
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)).translationKey(name));
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

//EXAMPLE:

public static void initialize() //wow
    {
        Identifier id = Identifier.of(Testmod.MOD_ID, "id_here");

        Block[] customBlocks =
                {
                        register(new Block(AbstractBlock.Settings.create()
                                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, id))
                                        .overrideTranslationKey("Name here")
                                        .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
                                "id_here",
                                true,
                                "Name here")
                };

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(customBlocks[0].asItem());
        });
    }
