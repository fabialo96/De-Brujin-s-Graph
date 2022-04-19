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

public class Flatmap_tips1 implements PairFlatMapFunction <Tuple2<String, Iterable<Tuple3<String, Integer, Integer>>>,
String, Tuple3<String,Integer,Integer>> {
	@Override
	public Iterator<Tuple2<String, Tuple3<String, Integer, Integer>>> call(
			Tuple2<String, Iterable<Tuple3<String, Integer, Integer>>> t) throws Exception {
		
        List<Tuple2<String, Tuple3<String, Integer, Integer>>> output = new ArrayList<Tuple2<String, Tuple3<String, Integer, Integer>>>();
        Tuple3<String,Integer,Integer> temp = new Tuple3<String,Integer,Integer>("ff",5,5);
        int i = 0;
		    for(Tuple3<String,Integer,Integer> tuple:t._2) {
 				temp=tuple;
 				if(i == 0) {	
 				}
 				else { 		
 				String a = t._1;
 				String b = temp._1().substring(temp._1().length() - 1);
 				String c = a + b;
 				output.add(new Tuple2<>(t._1, new Tuple3<>(c, -1, -1)));
 				}
 				i++;
 			}
		return output.iterator();				
	}
	
}	
