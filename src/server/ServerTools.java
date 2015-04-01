package server;

import java.util.ArrayList;

public class ServerTools 
{
	private ArrayList<SectorTools> sectorTools;
	private PackagingTools packagingTools;
	private ReportTools reportTools;
	public ServerTools()
	{
		sectorTools = new ArrayList<SectorTools>();
		packagingTools = new PackagingTools();
		reportTools = new ReportTools();
	}
	
	public ArrayList<SectorTools> getSectorTools() 
	{
		return sectorTools;
	}
	public PackagingTools getPackagingTools() 
	{
		return packagingTools;
	}
	public ReportTools getReportTools() 
	{
		return reportTools;
	}
	
	public void addSectorTool(SectorTools sectorTool)
	{
		sectorTools.add(sectorTool);
	}
	
	
}
