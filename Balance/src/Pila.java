
public class Pila {
	Object [] pila;
	Integer tope,tam;
	
	public Integer getTope() {
		return tope;
	}
	public void setTope(Integer tope) {
		this.tope = tope;
	}
	
	public Pila(Integer tamanio){
		tope=-1;
		pila=new Object[tamanio];
		tam=tamanio;
	}
	
	public void push(Object dato){
	if(tope<tam-1){
		tope++;
		pila[tope]=dato;
	}else
		System.out.println("Desbordamiento");
	}
	public Object pop(){
		Object resultado=0;
		if(tope>-1){
			resultado=pila[tope];
			pila[tope]=null;
			tope--;
		}else
			System.out.println("subdesbordamiento");
		
		return resultado;
	}
	
	public Object peek()
	{
		    if(tope>-1){
			return pila[tope];
		}
		else{
			
			return null;
		}
			
	}


}
