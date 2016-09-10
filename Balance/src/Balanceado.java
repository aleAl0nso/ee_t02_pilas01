
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Balanceado {
	String cadena;
	Pila pila;
	public char []abierto={'(','[','{'};
	public char []cerrado={')',']','}'};
	ArrayList<String> arre= new ArrayList<>();
	
	Balanceado(){
		
		pila= new Pila(1000);
	}
	
	public void Balancear() throws IOException{
     verArchivo();
     for(int v=1;v<arre.size();v++){
    	 cadena=arre.get(v);
    	if(!(cadena.length()%2==0)){
			System.out.println("No");}
		else{
			if(comparar()<0)
				System.out.println("No");
			else System.out.println("Si");
		}
		}
	}
	
	public boolean vacio(){
		return (pila.getTope()<1);
	}
	
	public boolean esAbierto(char a){
		for(int y=0;y<3;y++){
			if(a==abierto[y]){
				pila.push(a);
				return true;}
			}
		return false;
	}
	public int comparar(){
		int val1=-1,val2=-2;
		for(int x=0;x<cadena.length();x++){
			if(!(esAbierto(cadena.charAt(x))))
			{
				if(!vacio()){
					for(int z=0;z<3;z++){
						if(cadena.charAt(x)==cerrado[z])
							val1=z; 
						}
					for(int i=0;i<3;i++){
						char com= (char) pila.peek();
						if(com==abierto[i]){
							val2=i;
							pila.pop();
					}}
					if(!(val1==val2))
						return -1;
				}	
					
			
			}
		}
		if(vacio())
		return 1;
		else return -1;
	}
	
public   void leerArchivo( BufferedReader br ) throws IOException{
	     
        
        String cade= br.readLine();
        while(cade != null){
          
        	arre.add(cade);
            cade= br.readLine();
        }
        }
public void verArchivo() throws IOException{
    try {
   	 String a = JOptionPane.showInputDialog("nombre del archivo");
        BufferedReader oh =new BufferedReader (new FileReader(a));
       
        leerArchivo(oh);
   } catch (FileNotFoundException e) {
       JOptionPane.showMessageDialog(null, e.getMessage());
   }}
	
	
	
	public static void main(String []args) throws IOException{
		Balanceado b = new Balanceado();
		b.Balancear();
	}

}
