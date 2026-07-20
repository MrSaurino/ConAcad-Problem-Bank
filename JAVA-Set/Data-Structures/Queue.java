public class cola {
    int datos[],cdes, ult, inic;
    boolean flag;
    cola(int n){
        datos=new int[n];
        inic=ult=0;
        cdes=n;
    }
    void in(int dato){
        if(cdes>0){
            if(ult==datos.length)
                ult=0;
           datos[ult++]=dato;
           cdes--;
        }else
            System.out.println("overflow");
    }
    int out(){
        int aux;
        if(inic==datos.length)
            inic=0;
       // else flag=true;
            aux = datos[inic++];
            cdes++;
            return aux;

    }
}
class filadin{
    Nodo inicio,fin;
    filadin(){
        inicio=fin=null;
    }
    void in(int dato){
        Nodo temporal=new Nodo(dato);
        if(inicio==null)
            inicio=fin=temporal;
        else {
            fin.siguiente=temporal;
            fin=temporal;
        }
    }
    Nodo out(){
        Nodo aux;
        aux=inicio;
        if(inicio!=null)
            inicio=inicio.siguiente;
            return aux;
    }
}