package ru.kpfu.itis.group11403.sharipova.polynom;

public class Polynom {
    public final double E=0.000000001;
	private double[] coef;
	public Polynom(double[] setCoef){
		if (setCoef!=null){
			coef= new double[setCoef.length];
			for(int i=0; i<setCoef.length; i++){
				coef[i]=setCoef[i];
			}	
		}	
	}
	// определяем длину массива коэфициентов
	public int getDegreeOfString(String textPol){
		String degreeStr="";
		int degree=0;
		boolean f=false;
		int i=0;
		
		if ((textPol.length()==1)||(textPol.equals("-1"))){
			degree=0;
		}
		else{
			while((textPol.charAt(i)!='+')&&(textPol.charAt(i)!='-')){
				if((textPol.charAt(i)=='x')&&(textPol.charAt(i+1)!='^')){
					degree=1;
				}
				else {
					//считываем макс. степень
					if(textPol.charAt(i)=='^'){
						f=true;
						i++;
					}
					if (f){ 
						degreeStr+=textPol.charAt(i);
					}
				}    
				++i;
			}
			degree=Integer.parseInt(degreeStr);
		}
		return degree;
	}
	public Polynom(String textPol){
		int degree=getDegreeOfString(textPol);
		coef=new double[degree+1];
		int j=0;
		for (;j<textPol.length();j++){
			String coefStr="";
			String degreeStr="";
			//считываем коэффициенты, учитывая, что последний коэф. может быть при свободном члене
			while((textPol.charAt(j)!='x')&&(j<textPol.length())){
				coefStr+=textPol.charAt(j);
				if (j==textPol.length()-1){break;}
				else{j++;}
			}
			// опр-м стпень эл-та
			// степень=1, но это слагаемое не последнее
			if ((j!=textPol.length()-1)&&(textPol.charAt(j)=='x')&&(textPol.charAt(j+1)!='^')){
				degree=1;
				j++;
			}
			else{
				// степень=1, но это слагаемое последнее
				if ((j==textPol.length()-1)&&(textPol.charAt(j)=='x')) {degree=1;}
				// степень свободного члена
				else if (j==textPol.length()-1){ degree=0;}
				// степень>1, пропускаем символы "x" и "^", также степень может быть двухзначной
				else { 
					j+=2;
					while(((textPol.charAt(j)!='+')&&(textPol.charAt(j)!='-'))&&(j<textPol.length())){
						degreeStr+=textPol.charAt(j);
						if ((j==textPol.length()-1)||(textPol.charAt(j+1)=='-')){break;}

					else{j++;}
				}
				}
			}
			//если строка степени пустая, значит степень=1 или 0 и переводить строку в число не нужно
			if (degreeStr.length()!=0){ degree=Integer.parseInt(degreeStr);}
			//если строка коэф-а пустая, коэф-т=1
			if ((coefStr.length()!=0)&&(!(coefStr.equals("-")))){
				if (coefStr.charAt(0)=='-'){
					coef[degree]=-Double.parseDouble(coefStr.substring(1));
				}
				else		
					coef[degree]=Double.parseDouble(coefStr);
			}
			else{
				if (coefStr.equals("-")){
					coef[degree]=-1;
				}
				else coef[degree]=1;
			}
		}
	}
	public String toString(){
		String stringPolynom="";
		for(int i=coef.length-1;i>=0;i--){
			if(coef[i]!=0){
				//свободный член, не выводим х^0
				if(i==0){ 
					if (coef[i]>0){
						stringPolynom+="+"+coef[i];
					}
					else stringPolynom+=coef[i];
				}
				//выводим x, a не не выводим х^1
				else if(i==1){
					if(coef[i]>0){
						stringPolynom+= (coef[i]!=1)?("+"+coef[i]+"x"):("+"+"x");
					}
					else stringPolynom+= (coef[i]!=-1)?(coef[i]+"x"):("-"+"x");
				}
				else {
					if(coef[i]>0){
						stringPolynom+= (coef[i]!=1)?("+"+coef[i]+"x^"+i):("+"+"x^"+i);
					}
					else stringPolynom+= (coef[i]!=-1)?(coef[i]+"x^"+i):("-"+"x^"+i);
				}
			}
		}
		//убираем '+' в начале
		return stringPolynom.substring(1);
	}

    private int getDegree( Polynom secondPol){   	
        if (secondPol.coef.length>coef.length){
        	return secondPol.coef.length;
        }
        else if(secondPol.coef.length<coef.length){
        	return coef.length;
        }
        else{
        	int degree=coef.length;
        	for(int i=coef.length-1; i>=0; i--){
        		if(Math.abs(secondPol.coef[i]+coef[i])<E){
        			degree--;
        		}
        		else break;
        	}
        	return degree;
        }    
    }
	public void add(Polynom secondPol){
		if (coef.length==secondPol.coef.length){
		  
		  double[] sum= new double[getDegree(secondPol)];
		  for (int i=0; i<sum.length; i++){
			sum[i]=coef[i]+secondPol.coef[i];
		  }
		  coef= new double[sum.length];
		  for(int i=0; i<sum.length; i++){
			  coef[i]=sum[i];
		  }
		}
		else if(coef.length>secondPol.coef.length){
			for(int i=0; i<secondPol.coef.length; i++){
				coef[i]+=secondPol.coef[i];
			}
		}
		else {
			for(int i=0; i<coef.length; i++){
				secondPol.coef[i]+=coef[i];	
			}
			coef= new double[secondPol.coef.length];
			for(int i=0; i<coef.length; i++){
				  coef[i]=secondPol.coef[i];
			  }
		}
	}
	public void minus(Polynom secondPol){
	
		secondPol.multiply(new Polynom("-1"));
		this.add(secondPol);
	}
	public void multiply(Polynom secondPol ){
		double[] product= new double[coef.length+secondPol.coef.length-1];
		for (int i=0; i<coef.length; i++){
			for (int j=0; j<secondPol.coef.length; j++){
				product[i+j]+=coef[i]*secondPol.coef[j];
			}
		}
		coef= new double[product.length];
		for(int i=0; i<product.length; i++){
			coef[i]=product[i];
		}
	}
	
	public static void main(String[] args) {
		double[] koef1={1, 1, 1};
		double[] koef2={1,78};
		
		
		
		Polynom firstPol= new Polynom(koef1);
		Polynom secondPol= new Polynom(koef2);
		System.out.println(firstPol.toString());
		System.out.println("add");
		System.out.println(secondPol.toString());
		firstPol.add(secondPol);
		System.out.println("="+firstPol.toString());
		System.out.println();
		
		System.out.println(firstPol.toString());
		System.out.println("minus");
		System.out.println(secondPol.toString());
		firstPol.minus(secondPol);
		System.out.println("="+firstPol.toString());
		System.out.println();
		
		System.out.println(firstPol.toString());
		System.out.println("multiply");
		System.out.println(secondPol.toString());
		firstPol.multiply(secondPol);
		System.out.println("="+firstPol.toString());
		System.out.println();
		
		System.out.println("test of method toString");
		Polynom p =new Polynom(new double[]{1,-1,1});
		p.toString();
		new Polynom("x^2-x+1");
		System.out.println(new Polynom(new Polynom(new double[]{1,-1,1}).toString()));		
	}

}
