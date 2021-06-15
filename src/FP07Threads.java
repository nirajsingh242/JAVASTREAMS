
public class FP07Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run=new Runnable()
				{

					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(int i=0;i<1000;i++)
						System.out.println(Thread.currentThread().getId()+" : "+i);
					}
					
				};
				
				
				Thread  thread=new Thread(run);
				thread.start();
				
				Thread  thread1=new Thread(run);
				thread1.start();
	
				Thread  thread2=new Thread(run);
				thread2.start();

				Thread  thread3=new Thread(run);
				thread3.start();
	
	}

}
