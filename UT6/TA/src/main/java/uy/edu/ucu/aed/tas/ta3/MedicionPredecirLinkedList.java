package uy.edu.ucu.aed.tas.ta3;

import java.util.LinkedList;

public class MedicionPredecirLinkedList extends Medible {

	private LinkedList<String> linkedList;

	public MedicionPredecirLinkedList(LinkedList<String> linkedList) {
		this.linkedList = linkedList;
	}

	@Override
	public void ejecutar(Object... params) {
		int repeticion = (int) params[0];
		LinkedList<String> ret = new LinkedList<>();
		String prefijo = (String) params[1];
		for (int i = 0; i < repeticion; i++) {
			for (String p : linkedList) {
				if (p.startsWith(prefijo)) {
					ret.add(p);
				}
			}
		}
	}

	@Override
	public Object getObjetoAMedirMemoria() {
		return this.linkedList;
	}
}
