//FUCHIMURAYUKA
//お問い合わせ情報のmodel

package model;

public class ContactBeans {
    
	//ID
	private int id;
	//お問い合わせ種類
	private int type;
	//お問い合わせ者名
	private String name;
	//EMAIL
	private String email;
	//性別
	private int gender;
	//お問い合わせ内容
	private String text;
	//TIME
	private String time;
	

	public ContactBeans() {
	}
	
	public ContactBeans(int id) {
		this.id=id;
	}
	
	public ContactBeans(int id,int type) {
		this.id=id;
		this.type=type;
	}

	//お問い合わせ種類、お問い合わせ者名、EMAIL,性別、お問い合わせ内容、timeを引数に持つ
	public ContactBeans(int type, String name, String email, int gender, String text,String time) {
		this.type = type;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.text = text;
		this.time = time;
	}

	//お問い合わせ種類、お問い合わせ者名、EMAIL,性別、お問い合わせ内容、time,IDを引数に持つ
	public ContactBeans(int id,int type, String name, String email, int gender, String text, String time) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.text = text;
		this.time=time;
	}

	//お問い合わせ内容取得
	public int getType() {
		return type;
	}
	
	//お問い合わせ内容セット
	public void setType(int type) {
		this.type = type;
	}

	//お問い合わせ者名取得
	public String getName() {
		return name;
	}

	//お問い合わせ者名セット
	public void setName(String name) {
		this.name = name;
	}

	//EMAIL取得
	public String getEmail() {
		return email;
	}

	//EMAILセット
	public void setEmail(String email) {
		this.email = email;
	}

	//性別取得
	public int getGender() {
		return gender;
	}

	//性別セット
	public void setGender(int gender) {
		this.gender = gender;
	}

	//お問い合わせ内容取得
	public String getText() {
		return text;
	}

	//お問い合わせ内容セット
	public void setText(String text) {
		this.text = text;
	}

	//ID取得
	public int getId() {
		return id;
	}

	//IDセット
	public void setId(int id) {
		this.id = id;
	}
	
	//time取得
		public String getTime() {
			return  time;
		}

		//timeセット
		public void setTime(String time) {
			this.time= time;
		}

}