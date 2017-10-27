import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.*;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.hdfs.server.blockmanagement.BlockPlacementPolicy;
import org.apache.hadoop.hdfs.server.datanode.DataNode;

public class HdfsTest {

	private static Configuration conf;
	private final static int NUM_DATA_NODES = 10;
	private final static int NUM_FILES = 10;
	private final static byte[] SOME_BYTES = new String("foo").getBytes();
	private static DistributedFileSystem dfs;
	private static ArrayList<DataNode> datanodes;
	private static MiniDFSCluster cluster;

	public static void main(String[] args) throws IOException {

		final InetSocketAddress addrs[] = new InetSocketAddress[4];
		final String[] hosts = new String[addrs.length];
		conf = new Configuration();
		cluster = new MiniDFSCluster.Builder(conf).numDataNodes(NUM_DATA_NODES).build();
		cluster.waitClusterUp();
		dfs = cluster.getFileSystem();
		datanodes = cluster.getDataNodes();

		for (int i = 0; i < addrs.length; i++) {
			addrs[i] = datanodes.get(i).getXferAddress();
			hosts[i] = addrs[i].getAddress().getHostAddress() + ":" + addrs[i].getPort();
		}

	}
}