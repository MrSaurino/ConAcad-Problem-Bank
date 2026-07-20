public class Pila {
    int datos[], tope;
    Pila(int cuantos){
        datos=new int[cuantos];
        tope=0;
    }
    void push(int cual){
        if(tope<datos.length)
        datos[tope++]=cual;
        else
            System.out.println("Overflow");
    }
    int pop(){
        if(tope>0)
        return datos[--tope];
        else
            return tope;
    }
}
class Nodo{
    int info;
    Nodo siguiente,Izq, Der;
    Nodo(int p_info){
        info=p_info;
        siguiente=null;
    }
}
class pilad{
    Nodo inicio;
    pilad(){
        inicio=null;
    }
    void m_push(int p_datoNuevo){
        Nodo temporal=new Nodo(p_datoNuevo);
        if(inicio==null)
            inicio=temporal;
        else {
            temporal.siguiente = inicio;
            inicio = temporal;
        }
    }
    Nodo m_pop(){
        Nodo aux;
        aux=inicio;
        if(inicio!=null)
            inicio=inicio.siguiente;
            return aux;
    }
}
//Apuntadores es la memoria dinamica