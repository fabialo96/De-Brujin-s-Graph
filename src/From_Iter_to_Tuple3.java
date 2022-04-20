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
import scala.Tuple3;

//
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.broadcast.Broadcast;

public class From_Iter_to_Tuple3 implements PairFlatMapFunction <Tuple2<String, Iterable<Tuple3<String, Integer, Integer>>>,
String, Tuple3<String,Integer,Integer>> {

	@Override
	public Iterator<Tuple2<String, Tuple3<String, Integer, Integer>>> call(
			Tuple2<String, Iterable<Tuple3<String, Integer, Integer>>> t) throws Exception {
		
        List<Tuple2<String, Tuple3<String, Integer, Integer>>> output = new ArrayList<Tuple2<String, 
        		Tuple3<String, Integer, Integer>>>();
     	    
 			for(Tuple3<String,Integer,Integer> tuple:t._2) {
 																
				output.add(new Tuple2<>(t._1, new Tuple3<>(tuple._1(), tuple._2(), tuple._3())));
 				
 			}
		
		return output.iterator();
					
	}
	
}	
