package kg;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.hdfs.server.datanode.DataNode;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.hadoop.hdfs.DistributedFileSystem;


public class TestHdfs {

	private static Configuration conf;
	private final static int NUM_DATA_NODES = 2;
	private final static int NUM_FILES = 2;
	private final static byte[] SOME_BYTES = new String("foo").getBytes();
	private static DistributedFileSystem dfs;
	private static ArrayList<DataNode> datanodes;
	private static MiniDFSCluster cluster;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		conf = new Configuration();
		cluster = new MiniDFSCluster.Builder(conf).numDataNodes(NUM_DATA_NODES).build();
		cluster.waitClusterUp();
		dfs = cluster.getFileSystem();
		datanodes = cluster.getDataNodes();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		if (cluster != null) {
//			cluster.shutdown();
//		}
	}

	@Test
	public void test() {
		System.out.println("Not yet implemented");
	}

}
