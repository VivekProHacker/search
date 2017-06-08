package com.coviam.ecom.entity;

public class SearchList {
		public int productid;
		public String name;
		public double price;
		public String imageurl;
		public int rating;
		public SearchList(){}
		@Override
		public String toString() {
			return "SearchList [productid=" + productid + ", name=" + name + ", price=" + price + ", imageurl="
					+ imageurl + ", rating=" + rating + "]";
		}
		public SearchList(int productId, String name, double price, String imageurl, int rating) {
			this.productid = productId;
			this.name = name;
			this.price = price;
			this.imageurl = imageurl;
			this.rating = rating;
		}
		
		
}
