package datamanagement;

import java.util.List;

import org.jdom.Element;

public class UnitManager {

  private static UnitManager self = null;

  private UnitMap unitMap_;

  /**
   * checks if this unit manager has been initialised,
   * if not initialized already the object is initialized
   * @return an initialised unit manager
   */
  public static UnitManager initializeUnitManager() {
    if (self == null)
      self = new UnitManager();
    return self;
  }

  private UnitManager() {
    unitMap_ = new UnitMap();
  }

  /**
   * Checks the unit map for a Unit with the unit Code specified
   *
   * @param unitCode the unique ID for the unit to be retrieved
   * @return the unit object with the specified unit ID
   */
  public IUnit getUnit(String unitCode) {
    IUnit unit = unitMap_.get(unitCode);

    return unit != null ? unit : createUnit(unitCode);
  }


  /**
   *  Creates a unit (aka subject) using data stored in an XML file
   *  @param unitCode the unique code for the unit e.g. ITC209
   *  @return a unit object contain all it's data ready for manipulation in code
   */
  private IUnit createUnit(String unitCode) {
    IUnit unit;

    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("unitTable").getChildren("unit"))
      if (unitCode.equals(el.getAttributeValue("uid"))) {
        StudentUnitRecordList studentUnitRecordList;
        studentUnitRecordList = null;
        unit = new Unit(el.getAttributeValue("uid"),
                el.getAttributeValue("name"),
                Float.valueOf(el.getAttributeValue("ps")).floatValue(),
                Float.valueOf(el.getAttributeValue("cr")).floatValue(),
                Float.valueOf(el.getAttributeValue("di")).floatValue(),
                Float.valueOf(el.getAttributeValue("hd")).floatValue(),
                Float.valueOf(el.getAttributeValue("ae")).floatValue(),
                Integer.valueOf(el.getAttributeValue("asg1wgt")).intValue(),
                Integer.valueOf(el.getAttributeValue("asg2wgt")).intValue(),
                Integer.valueOf(el.getAttributeValue("examwgt")).intValue(),
                StudentUnitRecordManager.instance().getRecordsByUnit(unitCode));

        unitMap_.put(unit.getUnitCode(), unit);
        return unit;
      }

    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }

  /**
   * creates a hashmap of units by retrieving values from an XML file.
   *
   * @return  a hashmap of unit Objects for use elswere
   */
  public UnitMap getUnits() {

    UnitMap units;
    IUnit unit;

    units = new UnitMap();
    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
            .getRootElement().getChild("unitTable").getChildren("unit")) {

      unit = new UnitProxy(el.getAttributeValue("uid"),
              el.getAttributeValue("name"));
      units.put(unit.getUnitCode(), unit);
    } // unit maps are filled with PROXY units

    return units;
  }

}
