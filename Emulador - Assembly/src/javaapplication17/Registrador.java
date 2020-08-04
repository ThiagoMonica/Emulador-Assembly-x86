package javaapplication17;

class Registrador {
	private String value;

	Registrador() {

	}

	Registrador(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}