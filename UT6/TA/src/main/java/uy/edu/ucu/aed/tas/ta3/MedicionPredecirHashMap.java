package uy.edu.ucu.aed.tas.ta3;

import java.util.HashMap;
import java.util.LinkedList;

public class MedicionPredecirHashMap extends Medible {

	private HashMap<String, String> hashMap;

	public MedicionPredecirHashMap(HashMap<String, String> hashMap) {
		this.hashMap = hashMap;
	}

	@Override
	public void ejecutar(Object... params) {
		int repeticion = (int) params[0];
		LinkedList<String> ret = new LinkedList<>();
		String prefijo = (String) params[1];
		for (int i = 0; i < repeticion; i++) {
			for (String p : hashMap.keySet()) {
				if (p.startsWith(prefijo)) {
					ret.add(p);
				}
			}
		}
	}

	@Override
	public Object getObjetoAMedirMemoria() {
		return this.hashMap;
	}
}
