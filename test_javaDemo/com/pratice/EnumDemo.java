package com.pratice;

public enum EnumDemo {
	PLUS{
		public double eval(double x, double y) {
			return x+y;
		}
	},
	MINUS{
		public double eval(double x, double y) {
			return x-y;
		}
	},
	MUTIPLY{
		public double eval(double x, double y) {
			return x*y;
		}
	},
	DIVDES{
		public double eval(double x, double y) {
			return x/y;
		}
	};
    public abstract double eval(double x,double y);
    public static void main(String[] args) {
		System.out.println(EnumDemo.PLUS.eval(12, 12));
	}
}
