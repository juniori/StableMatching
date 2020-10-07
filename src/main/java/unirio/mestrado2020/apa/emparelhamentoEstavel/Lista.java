package unirio.mestrado2020.apa.emparelhamentoEstavel;

public class Lista {

	No prim = null;
	int tamanho = 0;

	public int getPrimeiro(){
		if (prim == null) return -1;
		
		return prim.info;
	}
	
	public void inserirInicio(int info) {
		No no = new No();
		no.info = info;
		no.next = prim;
		prim = no;
		tamanho++;
	}

	public int retirarInicio() {
		if (prim == null)
			return -1;
		int info = prim.info;
		prim = prim.next;
		tamanho--;
		return info;
	}

	public void inserirFim(int info) {
		No no = new No();
		no.info = info;
		if (prim == null) {
			no.next = null;
			prim = no;
		} else {
			No local = prim;
			while (local.next != null) {
				local = local.next;
			}
			local.next = no;
			no.next = null;
		}
		tamanho++;
	}

	public int retirarFim() {

		if (prim == null)
			return -1;

		No local = prim;

		while (local.next != null) {
			No aux = local;
			local = local.next;
			if (local.next == null) {
				aux.next = null;
				tamanho--;
				return local.info;
			}

		}

		prim = null;
		tamanho--;
		return local.info;

	}

	public void inserirNoIndice(int indice, int info) {
		if (indice == 0) {
			inserirInicio(info);
		} else if (indice == tamanho) {
			inserirFim(info);
		} else {
			No local = prim;
			for (int i = 0; i < indice - 1; i++) {
				local = local.next;
			}
			No no = new No();
			no.info = info;
			no.next = local.next;
			local.next = no;
			tamanho++;

		}

	}

	public int retirarNoIndice(int indice) {
		if (indice < 0 || indice >= tamanho || prim == null) {
			return -1;
		} else if (indice == 0) {
			return retirarInicio();
		} else if (indice == tamanho - 1) {
			return retirarFim();
		}
		No local = prim;
		for (int i = 0; i < indice - 1; i++) {
			local = local.next;
		}
		int info = local.next.info;
		local.next = local.next.next;
		tamanho--;
		return info;
	}

	public String toString() {

		String str = "(" + tamanho + ") ";
		No local = prim;
		while (local != null) {
			str += local.info + " ";
			local = local.next;
		}
		return str;
	}

	private class No {
		int info;
		No next;
	}

	public static void main(String[] args) {
		Lista lista = new Lista();
		System.out.println(lista.toString());
		lista.inserirInicio(10);
		System.out.println(lista.toString());
		lista.inserirInicio(20);
		System.out.println(lista.toString());

		lista.inserirFim(50);
		System.out.println(lista.toString());

		lista.retirarFim();
		System.out.println(lista.toString());

		lista.inserirNoIndice(0, 100);
		System.out.println(lista.toString());
		
		lista.retirarNoIndice(1);
		System.out.println("retirarNoIndice: " +  lista.toString());		

		int x = -1;
		while ((x = lista.retirarInicio()) != -1) {
			System.out.println(lista.toString());

		}
	}
}
