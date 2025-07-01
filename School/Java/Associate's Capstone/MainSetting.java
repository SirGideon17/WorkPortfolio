import java.util.ArrayList;

public class MainSetting implements CampiagnInfoInterface {
    private ArrayList<String> setting;

    public MainSetting(String filePath, int bitComparision) {
        int settingLines = 2;
        setting = new ArrayList<String>();
        String mainSettingFileName = "\\Settings.txt";
        MainScanner scanner = new MainScanner(filePath, mainSettingFileName, settingLines, bitComparision);

        setting = scanner.generateAnswer(settingLines);
        addSpace();
    }

    private void addSpace() {
        setting.add(1, "\nDescription:");
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> copySetting = setting;
        return copySetting;
    }

    @Override
    public String getName() {
        return "Main Setting";
    }
}
