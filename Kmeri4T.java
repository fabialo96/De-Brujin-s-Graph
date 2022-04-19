package gebd.progetto;

//STEP-0: import required classes and interfaces
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
//
import scala.Tuple2;
//
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.broadcast.Broadcast;





public class Kmeri4T implements PairFlatMapFunction<String, String, String>

{
	int K = 3;
	int s= 1;
	public 	java.util.Iterator<Tuple2<String,String>>	call(String line)

	{
		
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
		List<Tuple2<String, String>> result = new ArrayList<Tuple2<String, String>>();
		List<Tuple2<String,String>> list = new ArrayList<Tuple2<String,String>>();
	for (String word : words) {
		if (word.length() >= 3) {
		 for (int i=0; i < word.length()-K ; i++) {
			 String kmerP = word.substring(i, K+i);
			 String kmerC = word.substring(i, K+i+1);
           list.add(new Tuple2<String,String>(kmerP, kmerC));
           s++;
		 }
       }      
	      
} return list.iterator();
}
}