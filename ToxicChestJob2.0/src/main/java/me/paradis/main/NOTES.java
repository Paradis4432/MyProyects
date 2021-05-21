package me.paradis.main;

public class NOTES {

    /**
     * heres a list of notes, details, and reminders, do not delete or edit
     * idea:
     * X list of item stacks are in a list of inventories that can spawn in a chest
        * config:
        *
         * chest1:
         *  delay: 10
         *  other time details:
         *
         *  loots:
         *      1:
     *              chance: 50
         *          1:
         *              item1 ItemStack
         *          2:
         *              item2 ItemStack
         *      2:
         *          items
         *
         * chest2:
         *   info:
        *       chance: 20
         *      chest 2 info
     *
     */

    /*todo list

        setup perms
        spawnChest.spawn finish
   1.


     */

    /*commands

    /chest
chest add
	location ---
	loot
		locationID ---
	item
		locationID lootID ---

chest remove
	location
		locationID -
	loot
		locationID lootID -
	item
		locationID lootID itemID -

chest replace
	location
		locationID -
	item
		locationID lootID itemID -

chest list
	location/locations -
	locationID
		lootID -

chest admin +
	reload
	give playerID locationID lootID
			itemID
	force
		locationID
			lootID
	set locationID lootID NUM

     */

    /*
    perms:

    chest.*
chest add - chest.add.*
	location - chest.add.location
	loot - chest.add.loot
		locationID
	item - chest.add.item
		locationID lootID

chest remove - chest.remove.*
	location - chest.remove.location
		locationID
	loot - chest.remove.loot
		locationID lootID
	item - chest.remove.item
		locationID lootID itemID

chest replace - chest.replace.*
	location - chest.replace.location
		locationID
	item - chest.replace.item
		locationID lootID itemID

chest list - chest.list
	location/locations/locationID
		lootID

chest admin - chest.admin.*
	reload - chest.admin.reload
	give playerID locationID lootID - chest.admin.give.loot | chest.admin.give.*
			itemID - chest.admin.give.loot.item
	force - chest.force.*
		locationID - chest.force.location
			lootID - chest.force.location.loot
	set locationID lootID NUM  - chest.set.chance

     */
}
