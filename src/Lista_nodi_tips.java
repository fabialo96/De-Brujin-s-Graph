package gebd.progetto;


import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
//
import scala.Tuple2;
import spire.optional.intervalGeometricPartialOrder;

//
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.broadcast.Broadcast;

public class Lista_nodi_tips implements FlatMapFunction<String, String> {
	
	
	int K = 4;
	
	public 	Iterator<String> call(String line) {
		
		/*
		 * Suddivido la stringa in input in sottostringhe
		 * equivalenti circa alle singole parole che formano il testo
		 * tramite il metodo split ed ottenendo un array di stringhe
		 */
		
		String[] words = line.split("\\W");
		
		/*
		 * Creo una lista di stringhe in cui ricopio, una ad una,
		 * tutte le parole precedentemente individuate
		 */
		
		List<String> list = new ArrayList<String>();
		int j = 0;
		
	for (String word : words) {
		if (word.length() >= 4) {
		 for (int i=0; i < word.length()-K+1 ; i++) {
			 
			 if(j == 0) {				 
				 String kmer1 = word.substring(i, K+i);
				 j++;				 
			 }
			 
			 else {
			 String kmer = word.substring(i, K+i);
             list.add(kmer);
			 }
		 }
       }      
	      
} return list.iterator();
}
}
