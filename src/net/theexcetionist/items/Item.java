package net.theexcetionist.items;

public class Item {
	public static Item[] items = new Item[100];
	
	public static final Item club = new Item("Club", 0, 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 1, 0, 1, 0, 0, 0);
	
	public static final Item leather_armor = new Item("Leather Armor", true, 2, 0, 2, 0, 2, 1); 
	public static final Item maille_armor = new Item("Maille Armor", true, 3, 0, 4, 0, 0, 2);
	public static final Item iron_armor = new Item("Iron Armor", true, 4, 0, 5, 0, 1, 3); 
	public static final Item plate_armor = new Item("Plate Armor", true, 5, 0, 8, 0, 3, 4);
	//public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	
	public static final Item wooden_sword = new Item("Wooden Sword", 6, 3, 1, 0, 0, 1);
	public static final Item fighting_axe = new Item("Fighting Axe", 7, 6, 0, 0, 0, 2); 
	public static final Item iron_spear = new Item("Boar Spear", 8, 5, 1, 0, 0, 3);
	public static final Item iron_staff = new Item("Iron Staff", 9, 0, 0, 3, 0, 4, true); 
	public static final Item steel_sword = new Item("Arming Sword", 10, 8, 0, 0, 0, 5); 
	public static final Item morningstar = new Item("Morningstar", 11, 10, 1, 0, 0, 6); //Malchalith 
	public static final Item royal_spear = new Item("Royal Spear", 12, 0, 0, 6, 2, 7, true);
	
	/*public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 0, 1, 0, 0, 0);
	public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 0, 1, 0, 0, 0);
	public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 0, 1, 0, 0, 0);
	public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 0, 1, 0, 0, 0);
	public static final Item club = new Item("Club", 2, 0, 0, 0, 0); 
	public static final Item ragged = new Item("Rag Robe", 0, 1, 0, 0, 0);*/
	
	
	
	public int rating = 0; 
	
	
	public String name;
	public int attackBonus, defenseBonus, magAttack, magDefense;
	public int id;
	public boolean isMagic;
	public boolean isArmor = false;
	
	public Item(String name, int id, int attackBonus,int defenseBonus,int magAttack,int magDefense, int rating){
		this.name = name;
		this.id = id;
		this.attackBonus = attackBonus;
		this.defenseBonus = defenseBonus;
		this.magAttack = magAttack;
		this.magDefense = magDefense;
		this.rating = rating;
		this.isMagic = false;
		
		Item.items[id] = this;
		
		//System.out.println(name);
	}
	
	public Item(String name, boolean isArmor, int id, int attackBonus,int defenseBonus,int magAttack,int magDefense, int rating){
		this(name, id, attackBonus, defenseBonus, magAttack, magDefense, rating);
		this.isMagic = false;
		this.isArmor = isArmor;
		
		//System.out.println(name);
	}
	
	
	public Item(String name, int id, int attackBonus,int defenseBonus,int magAttack,int magDefense, int rating, boolean isMagic){
		this(name, id, attackBonus, defenseBonus, magAttack, magDefense, rating);
		
		
		this.isMagic = isMagic;
		//System.out.println(name);
	}
	
	public static Item getItemFromRating(int rating){
		for(int i = 0; i < items.length; i++){
			if(items[i] != null && items[i].rating <= rating && (Math.random() * 1) < 0.5) return items[i];
		}
		return null;
	}
}
