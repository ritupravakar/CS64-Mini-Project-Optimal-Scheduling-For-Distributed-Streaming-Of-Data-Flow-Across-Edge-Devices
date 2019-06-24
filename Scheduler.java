
package in.dream_lab.echo.master;


import java.util.*;
import java.util.concurrent.TimeUnit ;

import in.dream_lab.echo.utils.DataflowInput;
import in.dream_lab.echo.utils.Processor;
import in.dream_lab.echo.utils.Device;
import in.dream_lab.echo.utils.InputStream;
//import in.dream_lab.interfaces.IScheduler;



public class  Scheduler  {

	public Scheduler() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Map<Processor,Device> schedule(List<Device> devices, DataflowInput inputDag){
		Map<Processor,Device> mapping = new HashMap<Processor,Device>();
		Set<Processor> processors = inputDag.getProcessors();
		for(Processor processor : processors){
			if(processor.getIsInput()){
				for(Device device : devices){
					if (device.getInputStreams() == null)
						continue;
					for(InputStream inputStream: device.getInputStreams()){
						 if(inputStream.getInputStream().equals(processor.getSourceUuid())){
							 mapping.put(processor, device);
							 //processors.remove(processor);
							 break;
						 }
					}
				}
			}
		}
		/*TODO: Test*/


int current = (int) ((Math.random()*1000)%devices.size());
		for(Processor processor : processors){
		    if (processor.getIsInput())
		    	continue;

                        int k=0,index=0;float maxx=0;
			 for(Device device : devices){
                              

System.out.print("CPU Available: ");			
System.out.println(device.getCpuAvail());
System.out.print("Device ID: ");
System.out.println(device.getDeviceUUID());
System.out.print("CPU Utilized: ");
System.out.println(device.getCpuUtil());
System.out.print("Memory Available: ");
System.out.println(device.getMemAvail());
System.out.print("Memory Utilized ");
System.out.println(device.getMemUtil());
System.out.println("");
System.out.println("");
/*
try 
{
  //  Thread.sleep(2000);
TimeUnit.SECONDS.sleep(30);
//} 
//catch(InterruptedException e)
//{}
*/



				if(maxx<(device.getCpuAvail()-device.getCpuUtil())*(device.getMemAvail()-device.getMemUtil()))
                                   {
					maxx=(device.getCpuAvail()-device.getCpuUtil())*(device.getMemAvail()-device.getMemUtil());
					System.out.println(maxx);
					System.out.println("\n");
					index=k;
					System.out.println(index);
                                        System.out.println("\n");


					}
					k+=1;
                               }

		//	printf("Selected device : \n");
		//	printf("% % % % \n",device.getCpuAvail(),device.getCpuUtil(),device.getMemAvail(),device.getMemUtil());
			mapping.put(processor, devices.get(index));
				
			System.out.println("DEVICE SELECTED IS");
System.out.println(index+1);                        
			current = (current + 1)%devices.size();
		}
		return mapping;
}


}
