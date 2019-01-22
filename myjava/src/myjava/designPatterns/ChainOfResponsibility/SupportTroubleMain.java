package myjava.designPatterns.ChainOfResponsibility;

public class SupportTroubleMain {

	public static void main(String[] args) {
		Trouble trouble = new Trouble(200);
		Support lessSupport = new LessSupport("lessSupport", 50);
		Support noSupport = new NoSupport("noSupport");
		Support oddSupport = new OddSupport("oddSupport");
		Support specialSupport = new SpecialSupport("specialSupport", 100);
		noSupport.setNextSupport(lessSupport).setNextSupport(oddSupport).setNextSupport(specialSupport);
		// Ö´ÐÐ
		noSupport.support(trouble);
	}

}
