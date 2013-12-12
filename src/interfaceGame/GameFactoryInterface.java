package interfaceGame;

public interface GameFactoryInterface {
	public FrameInterface makeFrame();

	public RuleInterface makeRule();

	public DataInterface makeData();
}
