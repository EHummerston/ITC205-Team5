package datamanagement;

public class ListUnitsCtl
{
  private UnitManager unitManager_;



  public ListUnitsCtl()
  {
    unitManager_ = UnitManager.initializeUnitManager();
  }



  public void listUnits(IUnitLister unitLister)
  {
    unitLister.clearUnits();
    UnitMap units = unitManager_.getUnits();
    for (String s : units.keySet())
      unitLister.addUnit(units.get(s));
  }
}
