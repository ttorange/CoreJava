package exceptionTest;

public class CargoBoat {
	int realContent;
	int maxContent;
	public void setMaxContent(int c) {
		maxContent=c;
	}
	public void loading(int m)throws DangerException{
		realContent+=m;
		if(realContent>maxContent) {
			realContent-=m;
			throw new DangerException();//throw出现在函数体中，throws出现在函数头
			}
		System.out.println("目前装了"+realContent+"吨货物");
	}

}
