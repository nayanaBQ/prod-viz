package edu.gatech.cs7450.prodviz.data;


public abstract class AbstractProduct {

	private String name;
	private Database database;
	private Classifier firstLevelClassifier;
	private Classifier secondLevelClassifier;
	private ITableSchema productTableSchema;
	private IReviewTableSchema reviewTableSchema;
	private ITableSchema userTableSchema;
	
	protected AbstractProduct(
			String name, Classifier firstLevelClassifier, Classifier secondLevelClassifier,
			ITableSchema productTableSchema, IReviewTableSchema reviewTableSchema, ITableSchema userTableSchema) {
		this.name = name;
		this.firstLevelClassifier = firstLevelClassifier;
		this.secondLevelClassifier = secondLevelClassifier;
		this.productTableSchema = productTableSchema;
		this.reviewTableSchema = reviewTableSchema;
		this.userTableSchema = userTableSchema;
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public Classifier getFirstLevelClassifier() {
		return firstLevelClassifier;
	}

	public Classifier getSecondLevelClassifier() {
		return secondLevelClassifier;
	}

	public ITableSchema getProductTableSchema() {
		return productTableSchema;
	}

	public IReviewTableSchema getReviewTableSchema() {
		return reviewTableSchema;
	}

	public ITableSchema getUserTableSchema() {
		return userTableSchema;
	}

	public String toString() {
		return this.getName();
	}
	
	public String getName() {
		return name;
	}
	
	protected void setDatabase(Database database) {
		this.database = database;
	}
}
