/*
 * To change thi    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
s license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JYearChooser;
import components.BookingServiceComponent;
import components.RoomComponent;
import components.ServiceComponent;
import dao.BookingDAOImpl;
import dao.BookingDetailDAOImpl;
import dao.CustomerDAOImpl;
import dao.FloorDAOImpl;
import dao.RoomDAOImpl;
import dao.RoomTypeDAOImpl;
import dao.ServiceDAOImpl;
import dao.ServiceDetailDAOImpl;
import db.DBUtilities;
import entities.Booking;
import entities.BookingDetail;
import entities.Customer;
import entities.Floor;
import entities.Room;
import entities.RoomType;
import entities.Service;
import entities.ServiceDetail;
import entities.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author trinh
 */
public class MainView extends javax.swing.JFrame {

    private Calendar maxSelectTime = Calendar.getInstance();
    private byte reloadRoomList = 1;
    private byte reloadServiceList = 1;
    private byte reloadRevenueChart = 0;
    private byte reloadRoomStatusChart = 0;
    private final User currentloggin;
    private int xx;
    private int xy;
    CardLayout cardLayout1;
    CardLayout cardLayout2;
    CardLayout cardLayout3;
    CardLayout cardLayout4;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width * 4 / 5;
    private int height = screenSize.height * 4 / 5;
    DefaultTableModel tableRoomType;
    private LinkedList<Room> roomList = null;
    private LinkedList<Room> filterRoomList;
    private RoomComponent preSelectedRoom = null;
    private LinkedList<Room> readyRoomList = new LinkedList<>();
    private HashSet<Room> bookingRoomList = new HashSet<>();
    private ServiceComponent preSelectedService = null;
    private LinkedList<Service> serviceList = null;
    private LinkedList<Service> filterServiceList = new LinkedList<>();
    private HashSet<Service> bookingServiceList = new HashSet<>();
    private LinkedList<Service> readyServiceList = new LinkedList<>();
    private LinkedList<ServiceDetail> serviceDetailList = new LinkedList<>();
    private LinkedList<Customer> customerList = null;
    private LinkedList<Booking> bookingList = new LinkedList<>();
    private LinkedList<Booking> bookingListDisplay = new LinkedList<>();
    private LinkedList<BookingDetail> bookingDetailList = new LinkedList<>();
    private Booking currentBooking = null;
    private LinkedList<BookingDetail> currentBookingDetailList;
    private LinkedList<Room> roomList3 = null;
    private LinkedList<Room> roomList4;
    private LinkedList<BookingDetail> bookingDetailList2;

    /**
     * Creates new form MainView
     */
    public MainView(User u) {
        roomList = RoomDAOImpl.getAllRooms();
        bookingList = BookingDAOImpl.getAllBookings();
        customerList = CustomerDAOImpl.getAllCustomers();
        serviceList = ServiceDAOImpl.getAllServices();
        bookingDetailList2 = BookingDetailDAOImpl.getAllBookingDetails();
        maxSelectTime.add(Calendar.YEAR, -18);
        this.currentloggin = u;
        initComponents();
        myInit();
        setLocationRelativeTo(null);
        mainOverLay.setVisible(false);
        rightSideOverLay.setVisible(false);
        cardLayout1 = (CardLayout) (pnlCards1.getLayout());
        cardLayout2 = (CardLayout) (pnlCards2.getLayout());
        cardLayout3 = (CardLayout) (pnlCards3.getLayout());
        cardLayout4 = (CardLayout) (pnlCards4.getLayout());
        lbUserName.setText(currentloggin.getFullName());
        lbRights.setText(currentloggin.getRights().getName());
        dialogLoadding.setBackground(new Color(0, 0, 0, 0));
        displayRevenueChart(2020);
        displayRoomStatusChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setting = new javax.swing.JDialog();
        settingOverLay = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnlHeaderSetting = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbCloseSetting = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtFloor = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnMinus = new keeptoo.KButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnPlus = new keeptoo.KButton();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRoomType = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnAddType = new keeptoo.KButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btnSaveFloor = new keeptoo.KButton();
        lbPreFloor = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtHotelName = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtHotelAddress = new javax.swing.JTextField();
        lbErrorBasicSetting = new javax.swing.JLabel();
        dialogAddType = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        pnlHeaderAddType = new javax.swing.JPanel();
        lbTitleAddType = new javax.swing.JLabel();
        lbCloseAddType = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTypeName = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtTypePrice = new javax.swing.JTextField();
        btnResetAddType = new keeptoo.KButton();
        btnSaveType = new keeptoo.KButton();
        lbErrorAddType = new javax.swing.JLabel();
        lbTypeId = new javax.swing.JLabel();
        popupTableType = new javax.swing.JPopupMenu();
        itemEdit = new javax.swing.JMenuItem();
        itemDelete = new javax.swing.JMenuItem();
        dialogWarning = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        pnlWarningHeader = new javax.swing.JPanel();
        lbWarningTitle = new javax.swing.JLabel();
        lbCloseDialogWarning = new javax.swing.JLabel();
        lbWarningResult = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        kGradientPanel14 = new keeptoo.KGradientPanel();
        btnWarningAccept = new keeptoo.KButton();
        kGradientPanel15 = new keeptoo.KGradientPanel();
        btnCloseDialogWarning = new keeptoo.KButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        lbWarningTitleDetail = new javax.swing.JLabel();
        lbWarning = new javax.swing.JLabel();
        dialogError = new javax.swing.JDialog();
        jPanel30 = new javax.swing.JPanel();
        pnlErrorHeader = new javax.swing.JPanel();
        lbErrorTitle = new javax.swing.JLabel();
        lbCloseDialogError = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        kGradientPanel17 = new keeptoo.KGradientPanel();
        btnCloseDialogError = new keeptoo.KButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lbErrorTitleDetail = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        dialogSuccess = new javax.swing.JDialog();
        jPanel34 = new javax.swing.JPanel();
        pnlSuccessHeader = new javax.swing.JPanel();
        lbSuccessTitle = new javax.swing.JLabel();
        lbCloseDialogSuccess = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        kGradientPanel18 = new keeptoo.KGradientPanel();
        btnCloseDialogSuccess = new keeptoo.KButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lbSuccessTitleDetail = new javax.swing.JLabel();
        lbSuccess = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        dialogAddRoom = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        pnlHeaderAddRoom = new javax.swing.JPanel();
        lbTitleAddRoom = new javax.swing.JLabel();
        lbCloseAddRoom = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtRoomName = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnSaveRoom = new keeptoo.KButton();
        lbErrorAddRoom = new javax.swing.JLabel();
        cbbAddRoomType = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        cbbAddRoomFloor = new javax.swing.JComboBox<>();
        txtAddRoom = new javax.swing.JTextField();
        popupRoomType1 = new javax.swing.JPopupMenu();
        editRoomType1 = new javax.swing.JMenuItem();
        cleaning = new javax.swing.JCheckBoxMenuItem();
        deleteRoomType1 = new javax.swing.JMenuItem();
        dialogAddService = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        pnlHeaderAddService = new javax.swing.JPanel();
        lbTitleAddService = new javax.swing.JLabel();
        lbCloseAddService = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();
        btnSaveService = new keeptoo.KButton();
        lbErrorAddService = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtServicePrice = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtServiceAmount = new javax.swing.JTextField();
        popupService = new javax.swing.JPopupMenu();
        editService = new javax.swing.JMenuItem();
        deleteService = new javax.swing.JMenuItem();
        dialogBookService = new javax.swing.JDialog();
        bookServiceOverlay = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        pnlHeaderBookService = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        lbCloseBookService = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        pnlCards3 = new javax.swing.JPanel();
        pnlCard31 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        cbbServiceSort2 = new javax.swing.JComboBox<>();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel61 = new javax.swing.JLabel();
        txtSearchService2 = new javax.swing.JTextField();
        spnlServiceList2 = new javax.swing.JScrollPane();
        pnlServiceList2 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        btnOpenPnlCard32 = new keeptoo.KButton();
        btnResetBookingServiceList = new keeptoo.KButton();
        pnlCard32 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        spnlServiceDetailList = new javax.swing.JScrollPane();
        pnlServiceDetailList = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        btnBookingServiceNext1 = new keeptoo.KButton();
        btnOpenPnlCard31 = new keeptoo.KButton();
        pnlCard33 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel110 = new javax.swing.JLabel();
        txtSearchRoom3 = new javax.swing.JTextField();
        spnlRoomList4 = new javax.swing.JScrollPane();
        pnlRoomList4 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        btnBookService2 = new keeptoo.KButton();
        btnOpenCard32 = new keeptoo.KButton();
        dialogAddCustomer = new javax.swing.JDialog();
        pnlHeaderAddCustomer = new javax.swing.JPanel();
        lbTitleAddCustomer = new javax.swing.JLabel();
        lbCloseAddCustomer = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtCustomerIdentityCard = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtCustomerPhone = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        dcCustomerBirthday = new com.toedter.calendar.JDateChooser();
        lbErrorAddCustomer = new javax.swing.JLabel();
        btnSaveCustomer = new keeptoo.KButton();
        lbCustomerId = new javax.swing.JLabel();
        txtAddCustomer = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        popupCustomer = new javax.swing.JPopupMenu();
        editCustomer = new javax.swing.JMenuItem();
        deleteCustomer = new javax.swing.JMenuItem();
        dialogBookRoom = new javax.swing.JDialog();
        jPanel50 = new javax.swing.JPanel();
        pnlCards4 = new javax.swing.JPanel();
        pnlCard41 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        cbbRoomFloor = new javax.swing.JComboBox<>();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel66 = new javax.swing.JLabel();
        txtSearchRoom2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cbbRoomType = new javax.swing.JComboBox<>();
        btnFilterRoom2 = new keeptoo.KButton();
        jPanel52 = new javax.swing.JPanel();
        btnOpenPnlCard42 = new keeptoo.KButton();
        btnResetBookingRoomList = new keeptoo.KButton();
        pnlCards5 = new javax.swing.JPanel();
        spnlRoomList2 = new javax.swing.JScrollPane();
        pnlRoomList2 = new javax.swing.JPanel();
        pnlCard42 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtCustomerIdentityCard2 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        txtCustomerName2 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        rdMale2 = new javax.swing.JRadioButton();
        rdFemale2 = new javax.swing.JRadioButton();
        jLabel91 = new javax.swing.JLabel();
        dcCustomerBirthday2 = new com.toedter.calendar.JDateChooser();
        jLabel94 = new javax.swing.JLabel();
        txtCustomerPhone2 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        txtCustomerEmail2 = new javax.swing.JTextField();
        lbErrorCustomerInfo = new javax.swing.JLabel();
        btnOpenPnlCard41 = new keeptoo.KButton();
        btnCheckin = new keeptoo.KButton();
        lbCustomerId2 = new javax.swing.JLabel();
        btnBookingRoom = new keeptoo.KButton();
        lbNewCustomer = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        pnlHeaderBookRoom = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        lbCloseBookRoom = new javax.swing.JLabel();
        dialogLoadding = new javax.swing.JDialog();
        jLabel44 = new javax.swing.JLabel();
        dialogBooking = new javax.swing.JDialog();
        dialogBookingOverLay = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        lbBookingId = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        lbCustomerName = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        lbCustomerIdentityCard = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        lbCustomerGender = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        lbCustomerBirthday = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        lbCustomerPhone = new javax.swing.JLabel();
        lbCustomerEmail = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        spnlTblBooking = new javax.swing.JScrollPane();
        tblBooking = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        btnBookingAction = new keeptoo.KButton();
        pnlBookingHeader = new javax.swing.JPanel();
        lbCloseDialogBooking = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        lbBookingUserId = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lbBookingUserName = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        lbBookingUserRights = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        lbPayDate = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        dialogBookingDetail = new javax.swing.JDialog();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        lbRoomName = new javax.swing.JLabel();
        lbRoomType = new javax.swing.JLabel();
        lbRoomPrice = new javax.swing.JLabel();
        lbCountDate = new javax.swing.JLabel();
        lbRoomCost = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        spnlTblBookingDetail = new javax.swing.JScrollPane();
        tblBookingDetail = new javax.swing.JTable();
        jPanel70 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        lbTotal2 = new javax.swing.JLabel();
        pnlBookingDetailHeader = new javax.swing.JPanel();
        lbCloseDialogBookingDetaill = new javax.swing.JLabel();
        lbBookingDetaillTitle = new javax.swing.JLabel();
        dialogBookingInfo = new javax.swing.JDialog();
        bookingInfoOverlay = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        pnlBookingInfoHeader = new javax.swing.JPanel();
        lbCloseDialogBookingInfo = new javax.swing.JLabel();
        lbBookingDetaillTitle1 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        lbCustomerIdentityCard2 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        lbCustomerName2 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        lbCustomerGender2 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        lbCustomerPhone2 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        lbUserId2 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        lbUserName2 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        lbUserRights2 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        lbBookingId2 = new javax.swing.JLabel();
        spnlRoomList3 = new javax.swing.JScrollPane();
        pnlRoomList3 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        lbCheckin2 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        btnPay = new keeptoo.KButton();
        btnCancelBook = new keeptoo.KButton();
        btnGetRoom = new keeptoo.KButton();
        mainOverLay = new javax.swing.JPanel();
        bg = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlOpenPnlCard11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlOpenPnlCard12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlOpenPnlCard13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlOpenPnlCard14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlOpenPnlCard15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlSignOut = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnlSetting = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        rightSideOverLay = new javax.swing.JPanel();
        pnlCards1 = new javax.swing.JPanel();
        pnlCard11 = new javax.swing.JPanel();
        pnlCard12 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        btnAddRoom = new keeptoo.KButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbbFilterFloor = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        cbbFilterRoomType = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cbbFilterStatus = new javax.swing.JComboBox<>();
        jPanel35 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btnFilterRoom = new keeptoo.KButton();
        txtSearchRoom = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        btnSearchRoom = new keeptoo.KButton();
        jLabel46 = new javax.swing.JLabel();
        spnlRoomList = new javax.swing.JScrollPane();
        pnlRoomList = new javax.swing.JPanel();
        pnlCard13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        btnBookRoom = new keeptoo.KButton();
        jPanel12 = new javax.swing.JPanel();
        lbOpenCard21 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbOpenCard22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbOpenCard23 = new javax.swing.JLabel();
        pnlCards2 = new javax.swing.JPanel();
        pnlCard21 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel76 = new javax.swing.JLabel();
        txtSearchBooking5 = new javax.swing.JTextField();
        spnlPreBook = new javax.swing.JScrollPane();
        tblPreBook = new javax.swing.JTable();
        pnlCard22 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel74 = new javax.swing.JLabel();
        txtSearchBooking4 = new javax.swing.JTextField();
        spnlUsing = new javax.swing.JScrollPane();
        tblUsing = new javax.swing.JTable();
        pnlCard23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel73 = new javax.swing.JLabel();
        txtSearchBooking3 = new javax.swing.JTextField();
        cbbBookingHistoryMonth = new com.toedter.calendar.JMonthChooser();
        cbbBookingHistoryYear = new com.toedter.calendar.JYearChooser();
        spnlBookingHistory = new javax.swing.JScrollPane();
        tblBookingHistory = new javax.swing.JTable();
        pnlCard14 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        btnAddService = new keeptoo.KButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        btnBookService = new keeptoo.KButton();
        jLabel53 = new javax.swing.JLabel();
        cbbServiceSort = new javax.swing.JComboBox<>();
        cbbServiceStatus = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        btnFilterService = new keeptoo.KButton();
        jLabel56 = new javax.swing.JLabel();
        txtSearchService = new javax.swing.JTextField();
        spnlServiceList = new javax.swing.JScrollPane();
        pnlServiceList = new javax.swing.JPanel();
        pnlCard15 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        btnAddCustomer = new keeptoo.KButton();
        jLabel69 = new javax.swing.JLabel();
        txtSearchCustomer = new javax.swing.JTextField();
        spnlCustomerList = new javax.swing.JScrollPane();
        tblCustomerList = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        pnlCloseWelcome = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlMinimizeWelcome = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        test20 = new javax.swing.JPanel();
        kGradientPanel24 = new keeptoo.KGradientPanel();
        jLabel185 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        lbRights = new javax.swing.JLabel();

        setting.setMinimumSize(new java.awt.Dimension(510, 585));
        setting.setModal(true);
        setting.setUndecorated(true);
        setting.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        settingOverLay.setBackground(new Color(0,0,0,80));
        settingOverLay.setMinimumSize(new java.awt.Dimension(510, 585));
        settingOverLay.setPreferredSize(new java.awt.Dimension(510, 585));

        javax.swing.GroupLayout settingOverLayLayout = new javax.swing.GroupLayout(settingOverLay);
        settingOverLay.setLayout(settingOverLayLayout);
        settingOverLayLayout.setHorizontalGroup(
            settingOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        settingOverLayLayout.setVerticalGroup(
            settingOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        setting.getContentPane().add(settingOverLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(510, 585));
        jPanel3.setPreferredSize(new java.awt.Dimension(510, 585));

        pnlHeaderSetting.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderSetting.setPreferredSize(new java.awt.Dimension(510, 60));
        pnlHeaderSetting.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderSettingMouseDragged(evt);
            }
        });
        pnlHeaderSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderSettingMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cài đặt khách sạn");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbCloseSetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseSettingMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderSettingLayout = new javax.swing.GroupLayout(pnlHeaderSetting);
        pnlHeaderSetting.setLayout(pnlHeaderSettingLayout);
        pnlHeaderSettingLayout.setHorizontalGroup(
            pnlHeaderSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderSettingLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCloseSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeaderSettingLayout.setVerticalGroup(
            pnlHeaderSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderSettingLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(pnlHeaderSettingLayout.createSequentialGroup()
                .addComponent(lbCloseSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(510, 570));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số tầng của khách sạn:");

        txtFloor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFloor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtFloor.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtFloor.setEnabled(false);
        txtFloor.setPreferredSize(new java.awt.Dimension(360, 30));
        txtFloor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFloorKeyPressed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMinimumSize(new java.awt.Dimension(40, 28));
        jPanel8.setPreferredSize(new java.awt.Dimension(40, 28));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/minuswhite17.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, 30, 20));

        btnMinus.setkBackGroundColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkBorderRadius(20);
        btnMinus.setkEndColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkHoverColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkHoverEndColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        btnMinus.setkHoverStartColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkPressedColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkSelectedColor(new java.awt.Color(110, 89, 222));
        btnMinus.setkStartColor(new java.awt.Color(110, 89, 222));
        btnMinus.setMaximumSize(new java.awt.Dimension(40, 28));
        btnMinus.setMinimumSize(new java.awt.Dimension(40, 28));
        btnMinus.setPreferredSize(new java.awt.Dimension(40, 28));
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });
        jPanel8.add(btnMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/pluswhite17.png"))); // NOI18N
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, 30, 20));

        btnPlus.setkBackGroundColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkBorderRadius(20);
        btnPlus.setkEndColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkHoverColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkHoverEndColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkHoverForeGround(new java.awt.Color(204, 204, 204));
        btnPlus.setkHoverStartColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkPressedColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkSelectedColor(new java.awt.Color(110, 89, 222));
        btnPlus.setkStartColor(new java.awt.Color(110, 89, 222));
        btnPlus.setMaximumSize(new java.awt.Dimension(40, 28));
        btnPlus.setMinimumSize(new java.awt.Dimension(40, 28));
        btnPlus.setPreferredSize(new java.awt.Dimension(40, 28));
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        jPanel15.add(btnPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Cài đặt loại phòng:");

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setPreferredSize(new java.awt.Dimension(470, 120));

        tblRoomType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblRoomType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Loại phòng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRoomType.setGridColor(new java.awt.Color(255, 255, 255));
        tblRoomType.setRowHeight(30);
        tblRoomType.setRowMargin(4);
        tblRoomType.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblRoomType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoomType.getTableHeader().setReorderingAllowed(false);
        tblRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblRoomTypeMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblRoomType);
        if (tblRoomType.getColumnModel().getColumnCount() > 0) {
            tblRoomType.getColumnModel().getColumn(0).setResizable(false);
            tblRoomType.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblRoomType.getColumnModel().getColumn(1).setResizable(false);
            tblRoomType.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRoomType.getColumnModel().getColumn(2).setResizable(false);
            tblRoomType.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(155, 40));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/pluswhite17.png"))); // NOI18N
        jLabel29.setText(" Thêm loại phòng");
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        btnAddType.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkBorderRadius(25);
        btnAddType.setkEndColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnAddType.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnAddType.setkStartColor(new java.awt.Color(122, 72, 221));
        btnAddType.setPreferredSize(new java.awt.Dimension(152, 30));
        btnAddType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTypeActionPerformed(evt);
            }
        });
        jPanel13.add(btnAddType, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(155, 40));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/savewhite18.png"))); // NOI18N
        jLabel33.setText(" Lưu lại");
        jPanel19.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        btnSaveFloor.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkBorderRadius(25);
        btnSaveFloor.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSaveFloor.setPreferredSize(new java.awt.Dimension(152, 30));
        btnSaveFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFloorActionPerformed(evt);
            }
        });
        jPanel19.add(btnSaveFloor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        lbPreFloor.setForeground(new java.awt.Color(255, 255, 255));
        lbPreFloor.setPreferredSize(new java.awt.Dimension(20, 8));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setText("Cài đặt cơ bản");

        txtHotelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHotelName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHotelName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtHotelName.setPreferredSize(new java.awt.Dimension(470, 30));
        txtHotelName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHotelNameFocusGained(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Tên khách sạn:");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Địa chỉ:");

        txtHotelAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHotelAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHotelAddress.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtHotelAddress.setPreferredSize(new java.awt.Dimension(470, 30));
        txtHotelAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHotelAddressFocusGained(evt);
            }
        });

        lbErrorBasicSetting.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbErrorBasicSetting.setForeground(new java.awt.Color(255, 0, 0));
        lbErrorBasicSetting.setMinimumSize(new java.awt.Dimension(350, 15));
        lbErrorBasicSetting.setPreferredSize(new java.awt.Dimension(350, 15));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbPreFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(230, 230, 230))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtHotelAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbErrorBasicSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(txtHotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHotelName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHotelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFloor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrorBasicSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPreFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeaderSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(pnlHeaderSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setting.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dialogAddType.setBackground(new java.awt.Color(255, 255, 255));
        dialogAddType.setMinimumSize(new java.awt.Dimension(304, 270));
        dialogAddType.setModal(true);
        dialogAddType.setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        pnlHeaderAddType.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderAddType.setPreferredSize(new java.awt.Dimension(510, 60));
        pnlHeaderAddType.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderAddTypeMouseDragged(evt);
            }
        });
        pnlHeaderAddType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderAddTypeMousePressed(evt);
            }
        });

        lbTitleAddType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTitleAddType.setForeground(new java.awt.Color(204, 204, 204));
        lbTitleAddType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleAddType.setText("Thêm loại phòng");
        lbTitleAddType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbCloseAddType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseAddType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseAddType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseAddTypeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderAddTypeLayout = new javax.swing.GroupLayout(pnlHeaderAddType);
        pnlHeaderAddType.setLayout(pnlHeaderAddTypeLayout);
        pnlHeaderAddTypeLayout.setHorizontalGroup(
            pnlHeaderAddTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddTypeLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbTitleAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbCloseAddType)
                .addGap(5, 5, 5))
        );
        pnlHeaderAddTypeLayout.setVerticalGroup(
            pnlHeaderAddTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddTypeLayout.createSequentialGroup()
                .addGroup(pnlHeaderAddTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel30.setText("Tên loại phòng:");
        jLabel30.setToolTipText("");

        txtTypeName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTypeName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTypeName.setPreferredSize(new java.awt.Dimension(255, 30));
        txtTypeName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypeNameFocusGained(evt);
            }
        });
        txtTypeName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypeNameKeyPressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel31.setText("Giá:");
        jLabel31.setToolTipText("");

        txtTypePrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTypePrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTypePrice.setPreferredSize(new java.awt.Dimension(255, 30));
        txtTypePrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypePriceFocusGained(evt);
            }
        });
        txtTypePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypePriceKeyPressed(evt);
            }
        });

        btnResetAddType.setText("Reset");
        btnResetAddType.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkBorderRadius(25);
        btnResetAddType.setkEndColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnResetAddType.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.setkStartColor(new java.awt.Color(122, 72, 221));
        btnResetAddType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAddTypeActionPerformed(evt);
            }
        });

        btnSaveType.setText("Lưu");
        btnSaveType.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkBorderRadius(25);
        btnSaveType.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveType.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSaveType.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSaveType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveTypeActionPerformed(evt);
            }
        });

        lbErrorAddType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbErrorAddType.setForeground(new java.awt.Color(255, 51, 0));
        lbErrorAddType.setPreferredSize(new java.awt.Dimension(245, 16));

        lbTypeId.setForeground(new java.awt.Color(255, 255, 255));
        lbTypeId.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbErrorAddType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTypeId)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnResetAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtTypePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlHeaderAddType, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnlHeaderAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTypePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbErrorAddType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetAddType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lbTypeId)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogAddTypeLayout = new javax.swing.GroupLayout(dialogAddType.getContentPane());
        dialogAddType.getContentPane().setLayout(dialogAddTypeLayout);
        dialogAddTypeLayout.setHorizontalGroup(
            dialogAddTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogAddTypeLayout.setVerticalGroup(
            dialogAddTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        itemEdit.setText("Chỉnh sửa");
        itemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditActionPerformed(evt);
            }
        });
        popupTableType.add(itemEdit);

        itemDelete.setText("Xóa");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteActionPerformed(evt);
            }
        });
        popupTableType.add(itemDelete);

        dialogWarning.setMinimumSize(new java.awt.Dimension(280, 194));
        dialogWarning.setModal(true);
        dialogWarning.setUndecorated(true);

        jPanel17.setBackground(new java.awt.Color(248, 248, 248));
        jPanel17.setMinimumSize(new java.awt.Dimension(280, 194));
        jPanel17.setPreferredSize(new java.awt.Dimension(280, 194));

        pnlWarningHeader.setBackground(new java.awt.Color(255, 176, 0));
        pnlWarningHeader.setToolTipText("");
        pnlWarningHeader.setMinimumSize(new java.awt.Dimension(280, 46));
        pnlWarningHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlWarningHeaderMouseDragged(evt);
            }
        });
        pnlWarningHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlWarningHeaderMousePressed(evt);
            }
        });

        lbWarningTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbWarningTitle.setForeground(new java.awt.Color(255, 255, 255));

        lbCloseDialogWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogWarning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogWarning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogWarningMousePressed(evt);
            }
        });

        lbWarningResult.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        lbWarningResult.setForeground(new Color(0,0,0,0));

        javax.swing.GroupLayout pnlWarningHeaderLayout = new javax.swing.GroupLayout(pnlWarningHeader);
        pnlWarningHeader.setLayout(pnlWarningHeaderLayout);
        pnlWarningHeaderLayout.setHorizontalGroup(
            pnlWarningHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWarningHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbWarningTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbWarningResult, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCloseDialogWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlWarningHeaderLayout.setVerticalGroup(
            pnlWarningHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbWarningTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlWarningHeaderLayout.createSequentialGroup()
                .addGroup(pnlWarningHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseDialogWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbWarningResult))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setPreferredSize(new java.awt.Dimension(280, 50));

        kGradientPanel14.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel14.setkBorderRadius(15);
        kGradientPanel14.setkEndColor(new java.awt.Color(255, 176, 0));
        kGradientPanel14.setkStartColor(new java.awt.Color(255, 176, 0));
        kGradientPanel14.setMinimumSize(new java.awt.Dimension(120, 32));
        kGradientPanel14.setPreferredSize(new java.awt.Dimension(120, 32));

        btnWarningAccept.setBackground(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setBorder(null);
        btnWarningAccept.setText("Chấp nhận");
        btnWarningAccept.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnWarningAccept.setkBackGroundColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkBorderRadius(15);
        btnWarningAccept.setkEndColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkHoverColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkHoverEndColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnWarningAccept.setkHoverStartColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkIndicatorColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkPressedColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkSelectedColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setkStartColor(new java.awt.Color(255, 176, 0));
        btnWarningAccept.setMaximumSize(new java.awt.Dimension(116, 28));
        btnWarningAccept.setMinimumSize(new java.awt.Dimension(116, 28));
        btnWarningAccept.setPreferredSize(new java.awt.Dimension(116, 28));
        btnWarningAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarningAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel14Layout = new javax.swing.GroupLayout(kGradientPanel14);
        kGradientPanel14.setLayout(kGradientPanel14Layout);
        kGradientPanel14Layout.setHorizontalGroup(
            kGradientPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel14Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnWarningAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        kGradientPanel14Layout.setVerticalGroup(
            kGradientPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel14Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnWarningAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        kGradientPanel15.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel15.setkBorderRadius(20);
        kGradientPanel15.setkEndColor(new java.awt.Color(255, 176, 0));
        kGradientPanel15.setkStartColor(new java.awt.Color(255, 176, 0));
        kGradientPanel15.setMinimumSize(new java.awt.Dimension(120, 32));
        kGradientPanel15.setPreferredSize(new java.awt.Dimension(120, 32));

        btnCloseDialogWarning.setBackground(new java.awt.Color(255, 176, 0));
        btnCloseDialogWarning.setBorder(null);
        btnCloseDialogWarning.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCloseDialogWarning.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkBorderRadius(18);
        btnCloseDialogWarning.setkEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkForeGround(new java.awt.Color(255, 176, 0));
        btnCloseDialogWarning.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkHoverForeGround(new java.awt.Color(255, 176, 0));
        btnCloseDialogWarning.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setkStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogWarning.setLabel("Thoát");
        btnCloseDialogWarning.setMaximumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogWarning.setMinimumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogWarning.setPreferredSize(new java.awt.Dimension(116, 28));
        btnCloseDialogWarning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseDialogWarningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel15Layout = new javax.swing.GroupLayout(kGradientPanel15);
        kGradientPanel15.setLayout(kGradientPanel15Layout);
        kGradientPanel15Layout.setHorizontalGroup(
            kGradientPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel15Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        kGradientPanel15Layout.setVerticalGroup(
            kGradientPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel15Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                    .addContainerGap(150, Short.MAX_VALUE)
                    .addComponent(kGradientPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(kGradientPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setMinimumSize(new java.awt.Dimension(280, 94));
        jPanel29.setPreferredSize(new java.awt.Dimension(280, 94));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/warningorange45.png"))); // NOI18N

        lbWarningTitleDetail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbWarningTitleDetail.setForeground(new java.awt.Color(51, 51, 51));
        lbWarningTitleDetail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbWarningTitleDetail.setPreferredSize(new java.awt.Dimension(219, 40));

        lbWarning.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbWarning.setForeground(new java.awt.Color(102, 102, 102));
        lbWarning.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbWarning.setPreferredSize(new java.awt.Dimension(219, 46));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWarning, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbWarningTitleDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(lbWarningTitleDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWarningHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(pnlWarningHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout dialogWarningLayout = new javax.swing.GroupLayout(dialogWarning.getContentPane());
        dialogWarning.getContentPane().setLayout(dialogWarningLayout);
        dialogWarningLayout.setHorizontalGroup(
            dialogWarningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogWarningLayout.setVerticalGroup(
            dialogWarningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogError.setMinimumSize(new java.awt.Dimension(280, 194));
        dialogError.setModal(true);
        dialogError.setUndecorated(true);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setMinimumSize(new java.awt.Dimension(280, 194));

        pnlErrorHeader.setBackground(new java.awt.Color(255, 50, 8));
        pnlErrorHeader.setToolTipText("");
        pnlErrorHeader.setMinimumSize(new java.awt.Dimension(280, 46));
        pnlErrorHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlErrorHeaderMouseDragged(evt);
            }
        });
        pnlErrorHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlErrorHeaderMousePressed(evt);
            }
        });

        lbErrorTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbErrorTitle.setForeground(new java.awt.Color(255, 255, 255));

        lbCloseDialogError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogError.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogErrorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlErrorHeaderLayout = new javax.swing.GroupLayout(pnlErrorHeader);
        pnlErrorHeader.setLayout(pnlErrorHeaderLayout);
        pnlErrorHeaderLayout.setHorizontalGroup(
            pnlErrorHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlErrorHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbErrorTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbCloseDialogError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlErrorHeaderLayout.setVerticalGroup(
            pnlErrorHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlErrorHeaderLayout.createSequentialGroup()
                .addGroup(pnlErrorHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbErrorTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCloseDialogError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setPreferredSize(new java.awt.Dimension(280, 50));

        kGradientPanel17.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel17.setkBorderRadius(20);
        kGradientPanel17.setkEndColor(new java.awt.Color(255, 50, 8));
        kGradientPanel17.setkStartColor(new java.awt.Color(255, 50, 8));
        kGradientPanel17.setMinimumSize(new java.awt.Dimension(120, 32));
        kGradientPanel17.setPreferredSize(new java.awt.Dimension(120, 32));

        btnCloseDialogError.setBackground(new java.awt.Color(255, 50, 8));
        btnCloseDialogError.setBorder(null);
        btnCloseDialogError.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCloseDialogError.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkBorderRadius(18);
        btnCloseDialogError.setkEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkForeGround(new java.awt.Color(255, 50, 8));
        btnCloseDialogError.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkHoverForeGround(new java.awt.Color(255, 50, 8));
        btnCloseDialogError.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setkStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogError.setLabel("Thoát");
        btnCloseDialogError.setMaximumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogError.setMinimumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogError.setPreferredSize(new java.awt.Dimension(116, 28));
        btnCloseDialogError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseDialogErrorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel17Layout = new javax.swing.GroupLayout(kGradientPanel17);
        kGradientPanel17.setLayout(kGradientPanel17Layout);
        kGradientPanel17Layout.setHorizontalGroup(
            kGradientPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel17Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        kGradientPanel17Layout.setVerticalGroup(
            kGradientPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel17Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(kGradientPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setMinimumSize(new java.awt.Dimension(280, 94));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/errorred45.png"))); // NOI18N

        lbErrorTitleDetail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbErrorTitleDetail.setForeground(new java.awt.Color(51, 51, 51));
        lbErrorTitleDetail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbErrorTitleDetail.setPreferredSize(new java.awt.Dimension(219, 40));

        lbError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbError.setForeground(new java.awt.Color(102, 102, 102));
        lbError.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbError.setPreferredSize(new java.awt.Dimension(219, 46));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbErrorTitleDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addComponent(lbErrorTitleDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlErrorHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(pnlErrorHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout dialogErrorLayout = new javax.swing.GroupLayout(dialogError.getContentPane());
        dialogError.getContentPane().setLayout(dialogErrorLayout);
        dialogErrorLayout.setHorizontalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogErrorLayout.setVerticalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogSuccess.setMinimumSize(new java.awt.Dimension(280, 194));
        dialogSuccess.setModal(true);
        dialogSuccess.setUndecorated(true);

        jPanel34.setBackground(new java.awt.Color(248, 248, 248));
        jPanel34.setMinimumSize(new java.awt.Dimension(280, 194));

        pnlSuccessHeader.setBackground(new java.awt.Color(10, 217, 87));
        pnlSuccessHeader.setToolTipText("");
        pnlSuccessHeader.setMinimumSize(new java.awt.Dimension(280, 46));
        pnlSuccessHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlSuccessHeaderMouseDragged(evt);
            }
        });
        pnlSuccessHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSuccessHeaderMousePressed(evt);
            }
        });

        lbSuccessTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbSuccessTitle.setForeground(new java.awt.Color(255, 255, 255));

        lbCloseDialogSuccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogSuccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogSuccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogSuccessMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlSuccessHeaderLayout = new javax.swing.GroupLayout(pnlSuccessHeader);
        pnlSuccessHeader.setLayout(pnlSuccessHeaderLayout);
        pnlSuccessHeaderLayout.setHorizontalGroup(
            pnlSuccessHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuccessHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSuccessTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbCloseDialogSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSuccessHeaderLayout.setVerticalGroup(
            pnlSuccessHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuccessHeaderLayout.createSequentialGroup()
                .addGroup(pnlSuccessHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSuccessTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCloseDialogSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setPreferredSize(new java.awt.Dimension(280, 50));

        kGradientPanel18.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel18.setkBorderRadius(20);
        kGradientPanel18.setkEndColor(new java.awt.Color(10, 217, 87));
        kGradientPanel18.setkStartColor(new java.awt.Color(10, 217, 87));
        kGradientPanel18.setMinimumSize(new java.awt.Dimension(120, 32));
        kGradientPanel18.setPreferredSize(new java.awt.Dimension(120, 32));

        btnCloseDialogSuccess.setBackground(new java.awt.Color(10, 217, 87));
        btnCloseDialogSuccess.setBorder(null);
        btnCloseDialogSuccess.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCloseDialogSuccess.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkBorderRadius(18);
        btnCloseDialogSuccess.setkEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkForeGround(new java.awt.Color(10, 217, 87));
        btnCloseDialogSuccess.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkHoverForeGround(new java.awt.Color(10, 217, 87));
        btnCloseDialogSuccess.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setkStartColor(new java.awt.Color(255, 255, 255));
        btnCloseDialogSuccess.setLabel("Đóng");
        btnCloseDialogSuccess.setMaximumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogSuccess.setMinimumSize(new java.awt.Dimension(116, 28));
        btnCloseDialogSuccess.setPreferredSize(new java.awt.Dimension(116, 28));
        btnCloseDialogSuccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseDialogSuccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel18Layout = new javax.swing.GroupLayout(kGradientPanel18);
        kGradientPanel18.setLayout(kGradientPanel18Layout);
        kGradientPanel18Layout.setHorizontalGroup(
            kGradientPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel18Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );
        kGradientPanel18Layout.setVerticalGroup(
            kGradientPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel18Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnCloseDialogSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(kGradientPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setMinimumSize(new java.awt.Dimension(280, 94));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/successgreen46.png"))); // NOI18N

        lbSuccessTitleDetail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSuccessTitleDetail.setForeground(new java.awt.Color(51, 51, 51));
        lbSuccessTitleDetail.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbSuccessTitleDetail.setPreferredSize(new java.awt.Dimension(219, 40));

        lbSuccess.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbSuccess.setForeground(new java.awt.Color(102, 102, 102));
        lbSuccess.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbSuccess.setPreferredSize(new java.awt.Dimension(219, 46));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSuccess, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbSuccessTitleDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addComponent(lbSuccessTitleDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuccessHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(pnlSuccessHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout dialogSuccessLayout = new javax.swing.GroupLayout(dialogSuccess.getContentPane());
        dialogSuccess.getContentPane().setLayout(dialogSuccessLayout);
        dialogSuccessLayout.setHorizontalGroup(
            dialogSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogSuccessLayout.setVerticalGroup(
            dialogSuccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel32.setText("jLabel32");

        dialogAddRoom.setMinimumSize(new java.awt.Dimension(400, 355));
        dialogAddRoom.setModal(true);
        dialogAddRoom.setUndecorated(true);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(400, 355));
        jPanel10.setPreferredSize(new java.awt.Dimension(400, 355));

        pnlHeaderAddRoom.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderAddRoom.setMinimumSize(new java.awt.Dimension(400, 42));
        pnlHeaderAddRoom.setPreferredSize(new java.awt.Dimension(400, 42));
        pnlHeaderAddRoom.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderAddRoomMouseDragged(evt);
            }
        });
        pnlHeaderAddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderAddRoomMousePressed(evt);
            }
        });

        lbTitleAddRoom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTitleAddRoom.setForeground(new java.awt.Color(204, 204, 204));
        lbTitleAddRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleAddRoom.setText("Thêm phòng");
        lbTitleAddRoom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        lbTitleAddRoom.setPreferredSize(new java.awt.Dimension(344, 37));

        lbCloseAddRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseAddRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseAddRoom.setPreferredSize(new java.awt.Dimension(20, 25));
        lbCloseAddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseAddRoomMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderAddRoomLayout = new javax.swing.GroupLayout(pnlHeaderAddRoom);
        pnlHeaderAddRoom.setLayout(pnlHeaderAddRoomLayout);
        pnlHeaderAddRoomLayout.setHorizontalGroup(
            pnlHeaderAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddRoomLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbTitleAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCloseAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlHeaderAddRoomLayout.setVerticalGroup(
            pnlHeaderAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddRoomLayout.createSequentialGroup()
                .addGroup(pnlHeaderAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setText("Tên phòng");
        jLabel41.setToolTipText("");

        txtRoomName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtRoomName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtRoomName.setPreferredSize(new java.awt.Dimension(255, 30));
        txtRoomName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRoomNameFocusGained(evt);
            }
        });
        txtRoomName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRoomNameKeyPressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel42.setText("Loại phòng");
        jLabel42.setToolTipText("");

        btnSaveRoom.setText("Lưu");
        btnSaveRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkBorderRadius(25);
        btnSaveRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSaveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRoomActionPerformed(evt);
            }
        });

        lbErrorAddRoom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbErrorAddRoom.setForeground(new java.awt.Color(255, 51, 0));
        lbErrorAddRoom.setPreferredSize(new java.awt.Dimension(245, 16));

        cbbAddRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbbAddRoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbAddRoomTypeActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setText("Tầng");
        jLabel43.setToolTipText("");

        cbbAddRoomFloor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbbAddRoomFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbAddRoomFloorActionPerformed(evt);
            }
        });

        txtAddRoom.setForeground(new java.awt.Color(255, 255, 255));
        txtAddRoom.setBorder(null);
        txtAddRoom.setCaretColor(new java.awt.Color(255, 255, 255));
        txtAddRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAddRoom.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtAddRoom.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtAddRoom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddRoomKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeaderAddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(lbErrorAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnSaveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(txtAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbAddRoomFloor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbAddRoomType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(pnlHeaderAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbAddRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbAddRoomFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbErrorAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogAddRoomLayout = new javax.swing.GroupLayout(dialogAddRoom.getContentPane());
        dialogAddRoom.getContentPane().setLayout(dialogAddRoomLayout);
        dialogAddRoomLayout.setHorizontalGroup(
            dialogAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dialogAddRoomLayout.setVerticalGroup(
            dialogAddRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        editRoomType1.setText("Chỉnh sửa phòng");
        editRoomType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomType1ActionPerformed(evt);
            }
        });
        popupRoomType1.add(editRoomType1);

        cleaning.setText("Đang dọn dẹp");
        cleaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaningActionPerformed(evt);
            }
        });
        popupRoomType1.add(cleaning);

        deleteRoomType1.setText("Xóa phòng");
        deleteRoomType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomType1ActionPerformed(evt);
            }
        });
        popupRoomType1.add(deleteRoomType1);

        dialogAddService.setMinimumSize(new java.awt.Dimension(403, 359));
        dialogAddService.setModal(true);
        dialogAddService.setUndecorated(true);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setMinimumSize(new java.awt.Dimension(403, 359));

        pnlHeaderAddService.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderAddService.setMinimumSize(new java.awt.Dimension(400, 42));
        pnlHeaderAddService.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderAddServiceMouseDragged(evt);
            }
        });
        pnlHeaderAddService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderAddServiceMousePressed(evt);
            }
        });

        lbTitleAddService.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTitleAddService.setForeground(new java.awt.Color(204, 204, 204));
        lbTitleAddService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleAddService.setText("Thêm dịch vụ");
        lbTitleAddService.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        lbTitleAddService.setPreferredSize(new java.awt.Dimension(344, 37));

        lbCloseAddService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseAddService.setPreferredSize(new java.awt.Dimension(20, 25));
        lbCloseAddService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseAddServiceMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderAddServiceLayout = new javax.swing.GroupLayout(pnlHeaderAddService);
        pnlHeaderAddService.setLayout(pnlHeaderAddServiceLayout);
        pnlHeaderAddServiceLayout.setHorizontalGroup(
            pnlHeaderAddServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddServiceLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbTitleAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCloseAddService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnlHeaderAddServiceLayout.setVerticalGroup(
            pnlHeaderAddServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddServiceLayout.createSequentialGroup()
                .addGroup(pnlHeaderAddServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseAddService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel57.setText("Tên dịch vụ");
        jLabel57.setToolTipText("");

        txtServiceName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtServiceName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtServiceName.setPreferredSize(new java.awt.Dimension(255, 30));
        txtServiceName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServiceNameFocusGained(evt);
            }
        });
        txtServiceName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServiceNameKeyPressed(evt);
            }
        });

        btnSaveService.setText("Lưu");
        btnSaveService.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkBorderRadius(25);
        btnSaveService.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveService.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSaveService.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSaveService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveServiceActionPerformed(evt);
            }
        });

        lbErrorAddService.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbErrorAddService.setForeground(new java.awt.Color(255, 51, 0));
        lbErrorAddService.setPreferredSize(new java.awt.Dimension(245, 16));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel58.setText("Giá");
        jLabel58.setToolTipText("");

        txtServicePrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtServicePrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtServicePrice.setPreferredSize(new java.awt.Dimension(255, 30));
        txtServicePrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServicePriceFocusGained(evt);
            }
        });
        txtServicePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServicePriceKeyPressed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel59.setText("Số lượng");
        jLabel59.setToolTipText("");

        txtServiceAmount.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtServiceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtServiceAmount.setPreferredSize(new java.awt.Dimension(255, 30));
        txtServiceAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtServiceAmountFocusGained(evt);
            }
        });
        txtServiceAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServiceAmountKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeaderAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57)
                    .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServiceName, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel58)
                    .addComponent(txtServicePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jLabel59)
                    .addComponent(txtServiceAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(lbErrorAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(pnlHeaderAddService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServiceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbErrorAddService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveService, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogAddServiceLayout = new javax.swing.GroupLayout(dialogAddService.getContentPane());
        dialogAddService.getContentPane().setLayout(dialogAddServiceLayout);
        dialogAddServiceLayout.setHorizontalGroup(
            dialogAddServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dialogAddServiceLayout.setVerticalGroup(
            dialogAddServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        editService.setText("Cập nhật dịch vụ");
        editService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editServiceActionPerformed(evt);
            }
        });
        popupService.add(editService);

        deleteService.setText("Xóa dịch vụ");
        deleteService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServiceActionPerformed(evt);
            }
        });
        popupService.add(deleteService);

        dialogBookService.setMinimumSize(new java.awt.Dimension(510, 540));
        dialogBookService.setModal(true);
        dialogBookService.setUndecorated(true);
        dialogBookService.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookServiceOverlay.setBackground(new Color(0,0,0,80));
        bookServiceOverlay.setMinimumSize(new java.awt.Dimension(510, 540));

        javax.swing.GroupLayout bookServiceOverlayLayout = new javax.swing.GroupLayout(bookServiceOverlay);
        bookServiceOverlay.setLayout(bookServiceOverlayLayout);
        bookServiceOverlayLayout.setHorizontalGroup(
            bookServiceOverlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        bookServiceOverlayLayout.setVerticalGroup(
            bookServiceOverlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        dialogBookService.getContentPane().add(bookServiceOverlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel46.setMinimumSize(new java.awt.Dimension(510, 540));
        jPanel46.setPreferredSize(new java.awt.Dimension(510, 540));

        pnlHeaderBookService.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderBookService.setMinimumSize(new java.awt.Dimension(510, 54));
        pnlHeaderBookService.setPreferredSize(new java.awt.Dimension(510, 54));
        pnlHeaderBookService.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderBookServiceMouseDragged(evt);
            }
        });
        pnlHeaderBookService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderBookServiceMousePressed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(204, 204, 204));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Đặt dịch vụ");
        jLabel60.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jLabel60.setMaximumSize(new java.awt.Dimension(556, 32));
        jLabel60.setMinimumSize(new java.awt.Dimension(556, 32));
        jLabel60.setPreferredSize(new java.awt.Dimension(556, 32));

        lbCloseBookService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseBookService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseBookService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseBookServiceMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderBookServiceLayout = new javax.swing.GroupLayout(pnlHeaderBookService);
        pnlHeaderBookService.setLayout(pnlHeaderBookServiceLayout);
        pnlHeaderBookServiceLayout.setHorizontalGroup(
            pnlHeaderBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderBookServiceLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCloseBookService, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeaderBookServiceLayout.setVerticalGroup(
            pnlHeaderBookServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderBookServiceLayout.createSequentialGroup()
                .addComponent(lbCloseBookService, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderBookServiceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel43.setPreferredSize(new java.awt.Dimension(510, 486));

        pnlCards3.setPreferredSize(new java.awt.Dimension(510, 486));
        pnlCards3.setLayout(new java.awt.CardLayout());

        pnlCard31.setPreferredSize(new java.awt.Dimension(510, 486));

        jPanel44.setBackground(new java.awt.Color(223, 246, 250));
        jPanel44.setPreferredSize(new java.awt.Dimension(510, 52));

        cbbServiceSort2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbServiceSort2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá tăng dần", "Giá giảm dần" }));
        cbbServiceSort2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbServiceSort2ActionPerformed(evt);
            }
        });

        kGradientPanel2.setBackground(new java.awt.Color(223, 246, 250));
        kGradientPanel2.setkBorderRadius(25);
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchService2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchService2.setBorder(null);
        txtSearchService2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchService2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchService2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(txtSearchService2)
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbbServiceSort2, 0, 192, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbServiceSort2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnlServiceList2.setBackground(new java.awt.Color(255, 255, 255));
        spnlServiceList2.setBorder(null);
        spnlServiceList2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlServiceList2.setPreferredSize(new java.awt.Dimension(510, 380));

        pnlServiceList2.setBackground(new java.awt.Color(255, 255, 255));
        pnlServiceList2.setPreferredSize(new java.awt.Dimension(510, 380));

        javax.swing.GroupLayout pnlServiceList2Layout = new javax.swing.GroupLayout(pnlServiceList2);
        pnlServiceList2.setLayout(pnlServiceList2Layout);
        pnlServiceList2Layout.setHorizontalGroup(
            pnlServiceList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        pnlServiceList2Layout.setVerticalGroup(
            pnlServiceList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        spnlServiceList2.setViewportView(pnlServiceList2);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setPreferredSize(new java.awt.Dimension(510, 54));

        btnOpenPnlCard32.setText("Tiếp theo");
        btnOpenPnlCard32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpenPnlCard32.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkBorderRadius(35);
        btnOpenPnlCard32.setkEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOpenPnlCard32.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.setkStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenPnlCard32ActionPerformed(evt);
            }
        });

        btnResetBookingServiceList.setText("Đặt lại");
        btnResetBookingServiceList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnResetBookingServiceList.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkBorderRadius(35);
        btnResetBookingServiceList.setkEndColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnResetBookingServiceList.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.setkStartColor(new java.awt.Color(122, 72, 221));
        btnResetBookingServiceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBookingServiceListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(btnResetBookingServiceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnOpenPnlCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpenPnlCard32, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnResetBookingServiceList, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCard31Layout = new javax.swing.GroupLayout(pnlCard31);
        pnlCard31.setLayout(pnlCard31Layout);
        pnlCard31Layout.setHorizontalGroup(
            pnlCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnlCard31Layout.createSequentialGroup()
                .addGroup(pnlCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnlServiceList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCard31Layout.setVerticalGroup(
            pnlCard31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard31Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlServiceList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCards3.add(pnlCard31, "pnlCard31");

        pnlCard32.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard32.setPreferredSize(new java.awt.Dimension(510, 486));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setPreferredSize(new java.awt.Dimension(510, 52));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel62.setText("Danh sách dịch vụ đã chọn");
        jLabel62.setPreferredSize(new java.awt.Dimension(475, 30));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        spnlServiceDetailList.setBackground(new java.awt.Color(255, 255, 255));
        spnlServiceDetailList.setBorder(null);
        spnlServiceDetailList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlServiceDetailList.setPreferredSize(new java.awt.Dimension(510, 380));

        pnlServiceDetailList.setBackground(new java.awt.Color(255, 255, 255));
        pnlServiceDetailList.setPreferredSize(new java.awt.Dimension(510, 380));

        javax.swing.GroupLayout pnlServiceDetailListLayout = new javax.swing.GroupLayout(pnlServiceDetailList);
        pnlServiceDetailList.setLayout(pnlServiceDetailListLayout);
        pnlServiceDetailListLayout.setHorizontalGroup(
            pnlServiceDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        pnlServiceDetailListLayout.setVerticalGroup(
            pnlServiceDetailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        spnlServiceDetailList.setViewportView(pnlServiceDetailList);

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setPreferredSize(new java.awt.Dimension(510, 54));

        btnBookingServiceNext1.setText("Tiếp theo");
        btnBookingServiceNext1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBookingServiceNext1.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkBorderRadius(35);
        btnBookingServiceNext1.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBookingServiceNext1.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookingServiceNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingServiceNext1ActionPerformed(evt);
            }
        });

        btnOpenPnlCard31.setText("Quay lại");
        btnOpenPnlCard31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpenPnlCard31.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkBorderRadius(35);
        btnOpenPnlCard31.setkEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOpenPnlCard31.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.setkStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenPnlCard31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpenPnlCard31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBookingServiceNext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBookingServiceNext1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnOpenPnlCard31, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCard32Layout = new javax.swing.GroupLayout(pnlCard32);
        pnlCard32.setLayout(pnlCard32Layout);
        pnlCard32Layout.setHorizontalGroup(
            pnlCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(spnlServiceDetailList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard32Layout.setVerticalGroup(
            pnlCard32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard32Layout.createSequentialGroup()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlServiceDetailList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards3.add(pnlCard32, "pnlCard32");

        pnlCard33.setPreferredSize(new java.awt.Dimension(510, 486));

        jPanel77.setBackground(new java.awt.Color(223, 246, 250));
        jPanel77.setPreferredSize(new java.awt.Dimension(510, 52));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel100.setText("Chọn phòng muốn đặt dịch vụ");
        jLabel100.setPreferredSize(new java.awt.Dimension(475, 30));

        kGradientPanel7.setBackground(new java.awt.Color(223, 246, 250));
        kGradientPanel7.setkBorderRadius(25);
        kGradientPanel7.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchRoom3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearchRoom3.setBorder(null);
        txtSearchRoom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchRoom3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchRoom3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtSearchRoom3)
        );

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        spnlRoomList4.setBackground(new java.awt.Color(255, 255, 255));
        spnlRoomList4.setBorder(null);
        spnlRoomList4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlRoomList4.setMaximumSize(new java.awt.Dimension(510, 380));
        spnlRoomList4.setMinimumSize(new java.awt.Dimension(510, 380));
        spnlRoomList4.setPreferredSize(new java.awt.Dimension(510, 380));

        pnlRoomList4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlRoomList4Layout = new javax.swing.GroupLayout(pnlRoomList4);
        pnlRoomList4.setLayout(pnlRoomList4Layout);
        pnlRoomList4Layout.setHorizontalGroup(
            pnlRoomList4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        pnlRoomList4Layout.setVerticalGroup(
            pnlRoomList4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        spnlRoomList4.setViewportView(pnlRoomList4);

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setPreferredSize(new java.awt.Dimension(510, 54));

        btnBookService2.setText("Đặt dịch vụ");
        btnBookService2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBookService2.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkBorderRadius(35);
        btnBookService2.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBookService2.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookService2.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookService2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookService2ActionPerformed(evt);
            }
        });

        btnOpenCard32.setText("Quay lại");
        btnOpenCard32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpenCard32.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkBorderRadius(35);
        btnOpenCard32.setkEndColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOpenCard32.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.setkStartColor(new java.awt.Color(122, 72, 221));
        btnOpenCard32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCard32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpenCard32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBookService2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBookService2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnOpenCard32, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCard33Layout = new javax.swing.GroupLayout(pnlCard33);
        pnlCard33.setLayout(pnlCard33Layout);
        pnlCard33Layout.setHorizontalGroup(
            pnlCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(spnlRoomList4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard33Layout.setVerticalGroup(
            pnlCard33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard33Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlRoomList4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards3.add(pnlCard33, "pnlCard33");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCards3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCards3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlHeaderBookService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(pnlHeaderBookService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogBookService.getContentPane().add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dialogAddCustomer.setMinimumSize(new java.awt.Dimension(400, 494));
        dialogAddCustomer.setModal(true);
        dialogAddCustomer.setUndecorated(true);

        pnlHeaderAddCustomer.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderAddCustomer.setPreferredSize(new java.awt.Dimension(510, 60));
        pnlHeaderAddCustomer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderAddCustomerMouseDragged(evt);
            }
        });
        pnlHeaderAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderAddCustomerMousePressed(evt);
            }
        });

        lbTitleAddCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTitleAddCustomer.setForeground(new java.awt.Color(204, 204, 204));
        lbTitleAddCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleAddCustomer.setText("Thêm khách hàng");
        lbTitleAddCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbCloseAddCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseAddCustomerMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderAddCustomerLayout = new javax.swing.GroupLayout(pnlHeaderAddCustomer);
        pnlHeaderAddCustomer.setLayout(pnlHeaderAddCustomerLayout);
        pnlHeaderAddCustomerLayout.setHorizontalGroup(
            pnlHeaderAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddCustomerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbTitleAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCloseAddCustomer))
        );
        pnlHeaderAddCustomerLayout.setVerticalGroup(
            pnlHeaderAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderAddCustomerLayout.createSequentialGroup()
                .addGroup(pnlHeaderAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCloseAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitleAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel65.setText("Tên khách hàng");
        jLabel65.setToolTipText("");

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerName.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerNameFocusGained(evt);
            }
        });
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyPressed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel67.setText("Số chứng minh nhân dân");
        jLabel67.setToolTipText("");

        txtCustomerIdentityCard.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerIdentityCard.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerIdentityCard.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerIdentityCardFocusGained(evt);
            }
        });
        txtCustomerIdentityCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerIdentityCardKeyPressed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel68.setText("Giới tính");
        jLabel68.setToolTipText("");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel70.setText("Ngày sinh");
        jLabel70.setToolTipText("");

        txtCustomerPhone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerPhone.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerPhoneFocusGained(evt);
            }
        });
        txtCustomerPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerPhoneKeyPressed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel71.setText("Số điện thoại");
        jLabel71.setToolTipText("");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel72.setText("Email");
        jLabel72.setToolTipText("");

        txtCustomerEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerEmail.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerEmailFocusGained(evt);
            }
        });
        txtCustomerEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerEmailKeyPressed(evt);
            }
        });

        rdMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdMale);
        rdMale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rdMale.setText("Nam");
        rdMale.setPreferredSize(new java.awt.Dimension(51, 30));
        rdMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaleActionPerformed(evt);
            }
        });

        rdFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rdFemale.setText("Nữ");
        rdFemale.setPreferredSize(new java.awt.Dimension(41, 30));
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });

        dcCustomerBirthday.setDateFormatString("dd-MM-yyyy");
        dcCustomerBirthday.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dcCustomerBirthday.setMaxSelectableDate(maxSelectTime.getTime());
        dcCustomerBirthday.setPreferredSize(new java.awt.Dimension(360, 30));
        dcCustomerBirthday.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcCustomerBirthdayPropertyChange(evt);
            }
        });

        lbErrorAddCustomer.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbErrorAddCustomer.setForeground(new java.awt.Color(255, 51, 0));
        lbErrorAddCustomer.setPreferredSize(new java.awt.Dimension(360, 14));

        btnSaveCustomer.setText("Lưu");
        btnSaveCustomer.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkBorderRadius(25);
        btnSaveCustomer.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveCustomer.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSaveCustomer.setPreferredSize(new java.awt.Dimension(320, 32));
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });

        lbCustomerId.setForeground(new java.awt.Color(255, 255, 255));

        txtAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        txtAddCustomer.setBorder(null);
        txtAddCustomer.setCaretColor(new java.awt.Color(255, 255, 255));
        txtAddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAddCustomer.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtAddCustomer.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtAddCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddCustomerKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(rdMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel65)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67)
                    .addComponent(txtCustomerIdentityCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel70)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel71)
                    .addComponent(jLabel72)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcCustomerBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbErrorAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerIdentityCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcCustomerBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbErrorAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogAddCustomerLayout = new javax.swing.GroupLayout(dialogAddCustomer.getContentPane());
        dialogAddCustomer.getContentPane().setLayout(dialogAddCustomerLayout);
        dialogAddCustomerLayout.setHorizontalGroup(
            dialogAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeaderAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogAddCustomerLayout.setVerticalGroup(
            dialogAddCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddCustomerLayout.createSequentialGroup()
                .addComponent(pnlHeaderAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editCustomer.setText("Chỉnh sửa khách hàng");
        editCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerActionPerformed(evt);
            }
        });
        popupCustomer.add(editCustomer);

        deleteCustomer.setText("Xóa người dùng");
        deleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerActionPerformed(evt);
            }
        });
        popupCustomer.add(deleteCustomer);

        dialogBookRoom.setMinimumSize(new java.awt.Dimension(504, 574));
        dialogBookRoom.setModal(true);
        dialogBookRoom.setUndecorated(true);

        jPanel50.setPreferredSize(new java.awt.Dimension(504, 520));

        pnlCards4.setMinimumSize(new java.awt.Dimension(504, 520));
        pnlCards4.setPreferredSize(new java.awt.Dimension(504, 520));
        pnlCards4.setLayout(new java.awt.CardLayout());

        pnlCard41.setMinimumSize(new java.awt.Dimension(504, 520));
        pnlCard41.setPreferredSize(new java.awt.Dimension(504, 520));

        jPanel51.setBackground(new java.awt.Color(223, 246, 250));
        jPanel51.setMinimumSize(new java.awt.Dimension(504, 80));
        jPanel51.setPreferredSize(new java.awt.Dimension(504, 80));

        cbbRoomFloor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        kGradientPanel3.setBackground(new java.awt.Color(223, 246, 250));
        kGradientPanel3.setkBorderRadius(25);
        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchRoom2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearchRoom2.setBorder(null);
        txtSearchRoom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchRoom2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchRoom2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtSearchRoom2)
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setText("Chọn phòng muốn đặt");

        cbbRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnFilterRoom2.setText("Lọc");
        btnFilterRoom2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnFilterRoom2.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkBorderRadius(30);
        btnFilterRoom2.setkEndColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnFilterRoom2.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setkStartColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom2.setPreferredSize(new java.awt.Dimension(50, 30));
        btnFilterRoom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterRoom2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(cbbRoomFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFilterRoom2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbbRoomFloor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFilterRoom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbRoomType, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setMinimumSize(new java.awt.Dimension(504, 54));
        jPanel52.setName(""); // NOI18N
        jPanel52.setPreferredSize(new java.awt.Dimension(504, 54));

        btnOpenPnlCard42.setText("Tiếp theo");
        btnOpenPnlCard42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpenPnlCard42.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkBorderRadius(35);
        btnOpenPnlCard42.setkEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOpenPnlCard42.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.setkStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenPnlCard42ActionPerformed(evt);
            }
        });

        btnResetBookingRoomList.setText("Đặt lại");
        btnResetBookingRoomList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnResetBookingRoomList.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkBorderRadius(35);
        btnResetBookingRoomList.setkEndColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnResetBookingRoomList.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.setkStartColor(new java.awt.Color(122, 72, 221));
        btnResetBookingRoomList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBookingRoomListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResetBookingRoomList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnOpenPnlCard42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpenPnlCard42, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnResetBookingRoomList, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlCards5.setMinimumSize(new java.awt.Dimension(504, 386));
        pnlCards5.setPreferredSize(new java.awt.Dimension(504, 386));

        spnlRoomList2.setBackground(new java.awt.Color(255, 255, 255));
        spnlRoomList2.setBorder(null);
        spnlRoomList2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlRoomList2.setMinimumSize(new java.awt.Dimension(504, 386));
        spnlRoomList2.setPreferredSize(new java.awt.Dimension(504, 386));

        pnlRoomList2.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoomList2.setMinimumSize(new java.awt.Dimension(504, 386));
        pnlRoomList2.setPreferredSize(new java.awt.Dimension(504, 386));

        javax.swing.GroupLayout pnlRoomList2Layout = new javax.swing.GroupLayout(pnlRoomList2);
        pnlRoomList2.setLayout(pnlRoomList2Layout);
        pnlRoomList2Layout.setHorizontalGroup(
            pnlRoomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        pnlRoomList2Layout.setVerticalGroup(
            pnlRoomList2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        spnlRoomList2.setViewportView(pnlRoomList2);

        javax.swing.GroupLayout pnlCards5Layout = new javax.swing.GroupLayout(pnlCards5);
        pnlCards5.setLayout(pnlCards5Layout);
        pnlCards5Layout.setHorizontalGroup(
            pnlCards5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlRoomList2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCards5Layout.setVerticalGroup(
            pnlCards5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlRoomList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlCard41Layout = new javax.swing.GroupLayout(pnlCard41);
        pnlCard41.setLayout(pnlCard41Layout);
        pnlCard41Layout.setHorizontalGroup(
            pnlCard41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard41Layout.createSequentialGroup()
                .addGroup(pnlCard41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlCards5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCard41Layout.setVerticalGroup(
            pnlCard41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard41Layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCards5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCards4.add(pnlCard41, "pnlCard41");

        pnlCard42.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard42.setMinimumSize(new java.awt.Dimension(504, 520));
        pnlCard42.setPreferredSize(new java.awt.Dimension(504, 520));

        jPanel63.setBackground(new java.awt.Color(223, 246, 250));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel77.setText("Thông tin khách hàng");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel77)
                .addGap(6, 6, 6))
        );

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel84.setText("Số chứng minh nhân dân");
        jLabel84.setToolTipText("");

        txtCustomerIdentityCard2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerIdentityCard2.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerIdentityCard2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerIdentityCard2FocusGained(evt);
            }
        });
        txtCustomerIdentityCard2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerIdentityCard2KeyReleased(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel87.setText("Tên khách hàng");
        jLabel87.setToolTipText("");

        txtCustomerName2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerName2.setEnabled(false);
        txtCustomerName2.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerName2FocusGained(evt);
            }
        });
        txtCustomerName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerName2KeyPressed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel89.setText("Giới tính");
        jLabel89.setToolTipText("");

        rdMale2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdMale2);
        rdMale2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rdMale2.setSelected(true);
        rdMale2.setText("Nam");
        rdMale2.setEnabled(false);
        rdMale2.setPreferredSize(new java.awt.Dimension(51, 30));

        rdFemale2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdFemale2);
        rdFemale2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rdFemale2.setText("Nữ");
        rdFemale2.setEnabled(false);
        rdFemale2.setPreferredSize(new java.awt.Dimension(41, 30));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel91.setText("Ngày sinh");
        jLabel91.setToolTipText("");

        dcCustomerBirthday2.setDateFormatString("dd-MM-yyyy");
        dcCustomerBirthday2.setEnabled(false);
        dcCustomerBirthday2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dcCustomerBirthday2.setMaxSelectableDate(maxSelectTime.getTime());
        dcCustomerBirthday2.setPreferredSize(new java.awt.Dimension(360, 30));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel94.setText("Số điện thoại");
        jLabel94.setToolTipText("");

        txtCustomerPhone2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerPhone2.setEnabled(false);
        txtCustomerPhone2.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerPhone2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerPhone2FocusGained(evt);
            }
        });
        txtCustomerPhone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerPhone2KeyPressed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel96.setText("Email");
        jLabel96.setToolTipText("");

        txtCustomerEmail2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCustomerEmail2.setEnabled(false);
        txtCustomerEmail2.setPreferredSize(new java.awt.Dimension(255, 30));
        txtCustomerEmail2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerEmail2FocusGained(evt);
            }
        });

        lbErrorCustomerInfo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbErrorCustomerInfo.setForeground(new java.awt.Color(255, 0, 0));
        lbErrorCustomerInfo.setPreferredSize(new java.awt.Dimension(464, 16));

        btnOpenPnlCard41.setText("Quay lại");
        btnOpenPnlCard41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpenPnlCard41.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkBorderRadius(35);
        btnOpenPnlCard41.setkEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnOpenPnlCard41.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.setkStartColor(new java.awt.Color(122, 72, 221));
        btnOpenPnlCard41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenPnlCard41ActionPerformed(evt);
            }
        });

        btnCheckin.setText("Nhận phòng");
        btnCheckin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCheckin.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkBorderRadius(35);
        btnCheckin.setkEndColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnCheckin.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnCheckin.setkStartColor(new java.awt.Color(122, 72, 221));
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        lbCustomerId2.setForeground(new java.awt.Color(255, 255, 255));

        btnBookingRoom.setText("Đặt phòng");
        btnBookingRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBookingRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkBorderRadius(35);
        btnBookingRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBookingRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookingRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingRoomActionPerformed(evt);
            }
        });

        lbNewCustomer.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlCard42Layout = new javax.swing.GroupLayout(pnlCard42);
        pnlCard42.setLayout(pnlCard42Layout);
        pnlCard42Layout.setHorizontalGroup(
            pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard42Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCard42Layout.createSequentialGroup()
                        .addComponent(btnOpenPnlCard41, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnBookingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCard42Layout.createSequentialGroup()
                        .addComponent(rdMale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdFemale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel84, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCard42Layout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNewCustomer))
                    .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCard42Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCustomerId2))
                    .addComponent(txtCustomerIdentityCard2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerName2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcCustomerBirthday2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerPhone2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerEmail2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbErrorCustomerInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCard42Layout.setVerticalGroup(
            pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard42Layout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerIdentityCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(lbNewCustomer))
                .addGap(11, 11, 11)
                .addGroup(pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdFemale2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcCustomerBirthday2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(lbCustomerId2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbErrorCustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCard42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnOpenPnlCard41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBookingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlCards4.add(pnlCard42, "pnlCard42");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        pnlCards4.add(jPanel55, "card4");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCards4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCards4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlHeaderBookRoom.setBackground(new java.awt.Color(122, 72, 221));
        pnlHeaderBookRoom.setPreferredSize(new java.awt.Dimension(504, 54));
        pnlHeaderBookRoom.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderBookRoomMouseDragged(evt);
            }
        });
        pnlHeaderBookRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderBookRoomMousePressed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(204, 204, 204));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Đặt phòng");
        jLabel75.setMaximumSize(new java.awt.Dimension(452, 32));
        jLabel75.setMinimumSize(new java.awt.Dimension(452, 32));
        jLabel75.setPreferredSize(new java.awt.Dimension(452, 32));

        lbCloseBookRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseBookRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseBookRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseBookRoomMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderBookRoomLayout = new javax.swing.GroupLayout(pnlHeaderBookRoom);
        pnlHeaderBookRoom.setLayout(pnlHeaderBookRoomLayout);
        pnlHeaderBookRoomLayout.setHorizontalGroup(
            pnlHeaderBookRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderBookRoomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCloseBookRoom))
        );
        pnlHeaderBookRoomLayout.setVerticalGroup(
            pnlHeaderBookRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderBookRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlHeaderBookRoomLayout.createSequentialGroup()
                .addComponent(lbCloseBookRoom)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogBookRoomLayout = new javax.swing.GroupLayout(dialogBookRoom.getContentPane());
        dialogBookRoom.getContentPane().setLayout(dialogBookRoomLayout);
        dialogBookRoomLayout.setHorizontalGroup(
            dialogBookRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlHeaderBookRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBookRoomLayout.setVerticalGroup(
            dialogBookRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogBookRoomLayout.createSequentialGroup()
                .addComponent(pnlHeaderBookRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        dialogLoadding.setMinimumSize(new java.awt.Dimension(100, 100));
        dialogLoadding.setModal(true);
        dialogLoadding.setUndecorated(true);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/loading.gif"))); // NOI18N

        javax.swing.GroupLayout dialogLoaddingLayout = new javax.swing.GroupLayout(dialogLoadding.getContentPane());
        dialogLoadding.getContentPane().setLayout(dialogLoaddingLayout);
        dialogLoaddingLayout.setHorizontalGroup(
            dialogLoaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        dialogLoaddingLayout.setVerticalGroup(
            dialogLoaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        dialogBooking.setMinimumSize(new java.awt.Dimension(550, 596));
        dialogBooking.setModal(true);
        dialogBooking.setUndecorated(true);
        dialogBooking.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dialogBookingOverLay.setBackground(new Color(0,0,0,80));

        javax.swing.GroupLayout dialogBookingOverLayLayout = new javax.swing.GroupLayout(dialogBookingOverLay);
        dialogBookingOverLay.setLayout(dialogBookingOverLayLayout);
        dialogBookingOverLayLayout.setHorizontalGroup(
            dialogBookingOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        dialogBookingOverLayLayout.setVerticalGroup(
            dialogBookingOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        dialogBooking.getContentPane().add(dialogBookingOverLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(80, 80, 80));
        jLabel78.setText("Mã đặt phòng:");

        lbBookingId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBookingId.setForeground(new java.awt.Color(80, 80, 80));
        lbBookingId.setPreferredSize(new java.awt.Dimension(100, 16));

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(80, 80, 80));
        jLabel81.setText("Họ và tên: ");

        lbCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerName.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerName.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerName.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerName.setPreferredSize(new java.awt.Dimension(440, 16));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(80, 80, 80));
        jLabel93.setText("Số CMND: ");

        lbCustomerIdentityCard.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerIdentityCard.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerIdentityCard.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerIdentityCard.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerIdentityCard.setPreferredSize(new java.awt.Dimension(440, 16));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(80, 80, 80));
        jLabel95.setText("Giới tính: ");

        lbCustomerGender.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerGender.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerGender.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerGender.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerGender.setPreferredSize(new java.awt.Dimension(440, 16));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(80, 80, 80));
        jLabel97.setText("Ngày sinh: ");

        lbCustomerBirthday.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerBirthday.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerBirthday.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerBirthday.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerBirthday.setPreferredSize(new java.awt.Dimension(440, 16));

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(80, 80, 80));
        jLabel99.setText("Số điện thoại: ");

        lbCustomerPhone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerPhone.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerPhone.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerPhone.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerPhone.setPreferredSize(new java.awt.Dimension(440, 16));

        lbCustomerEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCustomerEmail.setForeground(new java.awt.Color(80, 80, 80));
        lbCustomerEmail.setMaximumSize(new java.awt.Dimension(440, 16));
        lbCustomerEmail.setMinimumSize(new java.awt.Dimension(440, 16));
        lbCustomerEmail.setPreferredSize(new java.awt.Dimension(440, 16));

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(80, 80, 80));
        jLabel102.setText("Địa chỉ email: ");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel99)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerIdentityCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(lbCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(lbCustomerIdentityCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(lbCustomerGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(lbCustomerBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(lbCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(lbCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel56.setBackground(new java.awt.Color(122, 72, 221));
        jPanel56.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel56.setPreferredSize(new java.awt.Dimension(530, 22));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Thông tin khách hàng");

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        spnlTblBooking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        spnlTblBooking.setPreferredSize(new java.awt.Dimension(554, 160));

        tblBooking.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Tên phòng", "Loại phòng", "Giá phòng", "<html><center>Số ngày<br> thuê</center></html>", "<html><center>Giá dịch vụ<br>đã dùng</center></html>", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooking.setGridColor(new java.awt.Color(245, 245, 245));
        tblBooking.setRowHeight(25);
        tblBooking.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblBooking.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBooking.getTableHeader().setResizingAllowed(false);
        tblBooking.getTableHeader().setReorderingAllowed(false);
        tblBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingMouseClicked(evt);
            }
        });
        spnlTblBooking.setViewportView(tblBooking);
        if (tblBooking.getColumnModel().getColumnCount() > 0) {
            tblBooking.getColumnModel().getColumn(0).setResizable(false);
            tblBooking.getColumnModel().getColumn(0).setPreferredWidth(39);
            tblBooking.getColumnModel().getColumn(1).setResizable(false);
            tblBooking.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblBooking.getColumnModel().getColumn(2).setResizable(false);
            tblBooking.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblBooking.getColumnModel().getColumn(3).setResizable(false);
            tblBooking.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblBooking.getColumnModel().getColumn(4).setResizable(false);
            tblBooking.getColumnModel().getColumn(4).setPreferredWidth(57);
            tblBooking.getColumnModel().getColumn(4).setHeaderValue("<html><center>Số ngày<br> thuê</center></html>");
            tblBooking.getColumnModel().getColumn(5).setResizable(false);
            tblBooking.getColumnModel().getColumn(5).setPreferredWidth(72);
            tblBooking.getColumnModel().getColumn(5).setHeaderValue("<html><center>Giá dịch vụ<br>đã dùng</center></html>");
            tblBooking.getColumnModel().getColumn(6).setResizable(false);
            tblBooking.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnlTblBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spnlTblBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel61.setBackground(new java.awt.Color(122, 72, 221));
        jPanel61.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel61.setPreferredSize(new java.awt.Dimension(530, 22));

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Thông tin chi tiết");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(80, 80, 80));
        jLabel82.setText("Tổng cộng:");
        jLabel82.setPreferredSize(new java.awt.Dimension(75, 26));

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(80, 80, 80));
        lbTotal.setPreferredSize(new java.awt.Dimension(200, 26));

        btnBookingAction.setBackground(new java.awt.Color(255, 255, 255));
        btnBookingAction.setText("Xác nhận thanh toán");
        btnBookingAction.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBookingAction.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkBorderRadius(25);
        btnBookingAction.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnBookingAction.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookingAction.setPreferredSize(new java.awt.Dimension(150, 26));
        btnBookingAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBookingAction, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(btnBookingAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pnlBookingHeader.setBackground(new java.awt.Color(122, 72, 221));
        pnlBookingHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBookingHeaderMouseDragged(evt);
            }
        });
        pnlBookingHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBookingHeaderMousePressed(evt);
            }
        });

        lbCloseDialogBooking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCloseDialogBooking.setPreferredSize(new java.awt.Dimension(24, 24));
        lbCloseDialogBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogBookingMousePressed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Hóa đơn đặt phòng");

        javax.swing.GroupLayout pnlBookingHeaderLayout = new javax.swing.GroupLayout(pnlBookingHeader);
        pnlBookingHeader.setLayout(pnlBookingHeaderLayout);
        pnlBookingHeaderLayout.setHorizontalGroup(
            pnlBookingHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCloseDialogBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBookingHeaderLayout.setVerticalGroup(
            pnlBookingHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingHeaderLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(pnlBookingHeaderLayout.createSequentialGroup()
                .addComponent(lbCloseDialogBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(80, 80, 80));
        jLabel79.setText("Thông tin người lập hóa đơn");

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(80, 80, 80));
        jLabel86.setText("Mã nhân viên:");

        lbBookingUserId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBookingUserId.setForeground(new java.awt.Color(80, 80, 80));
        lbBookingUserId.setPreferredSize(new java.awt.Dimension(222, 16));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(80, 80, 80));
        jLabel88.setText("Họ và tên:");

        lbBookingUserName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBookingUserName.setForeground(new java.awt.Color(80, 80, 80));
        lbBookingUserName.setPreferredSize(new java.awt.Dimension(222, 16));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(80, 80, 80));
        jLabel90.setText("Chức vụ:");

        lbBookingUserRights.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbBookingUserRights.setForeground(new java.awt.Color(80, 80, 80));
        lbBookingUserRights.setPreferredSize(new java.awt.Dimension(222, 16));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(80, 80, 80));
        jLabel92.setText("Ngày thu tiền:");

        lbPayDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbPayDate.setForeground(new java.awt.Color(80, 80, 80));
        lbPayDate.setPreferredSize(new java.awt.Dimension(100, 16));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBookingHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel54Layout.createSequentialGroup()
                                    .addComponent(jLabel92)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbPayDate, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel54Layout.createSequentialGroup()
                                    .addComponent(jLabel78)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbBookingId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86)
                            .addComponent(jLabel88)
                            .addComponent(jLabel90))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbBookingUserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbBookingUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbBookingUserRights, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(pnlBookingHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(lbBookingUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(lbBookingUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(lbBookingUserRights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addComponent(lbBookingId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(lbPayDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogBooking.getContentPane().add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dialogBookingDetail.setMinimumSize(new java.awt.Dimension(463, 382));
        dialogBookingDetail.setModal(true);
        dialogBookingDetail.setUndecorated(true);

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(80, 80, 80));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Tên phòng");
        jLabel101.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(245, 245, 245)));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(80, 80, 80));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("Loại phòng");
        jLabel103.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(245, 245, 245)));

        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(80, 80, 80));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Giá phòng");
        jLabel104.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        jLabel104.setPreferredSize(new java.awt.Dimension(80, 32));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(80, 80, 80));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("<html><center>Số ngày<br>thuê</center></html>");
        jLabel105.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        jLabel105.setPreferredSize(new java.awt.Dimension(50, 32));

        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(80, 80, 80));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Thành tiền");
        jLabel106.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(245, 245, 245)));

        lbRoomName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbRoomName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoomName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        lbRoomName.setPreferredSize(new java.awt.Dimension(100, 20));

        lbRoomType.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbRoomType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoomType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        lbRoomType.setPreferredSize(new java.awt.Dimension(100, 20));

        lbRoomPrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbRoomPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoomPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        lbRoomPrice.setPreferredSize(new java.awt.Dimension(80, 20));

        lbCountDate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbCountDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCountDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(245, 245, 245)));
        lbCountDate.setPreferredSize(new java.awt.Dimension(50, 20));

        lbRoomCost.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbRoomCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRoomCost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(245, 245, 245)));
        lbRoomCost.setPreferredSize(new java.awt.Dimension(90, 20));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(lbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbCountDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbRoomCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1, 1, 1)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCountDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRoomCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel67.setBackground(new java.awt.Color(122, 72, 221));
        jPanel67.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel67.setPreferredSize(new java.awt.Dimension(530, 22));

        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Chi phí phòng");

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));
        jPanel69.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        spnlTblBookingDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        spnlTblBookingDetail.setPreferredSize(new java.awt.Dimension(554, 160));

        tblBookingDetail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblBookingDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Tên dịch vụ", "Giá dịch vụ", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookingDetail.setGridColor(new java.awt.Color(245, 245, 245));
        tblBookingDetail.setRowHeight(25);
        tblBookingDetail.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblBookingDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBookingDetail.getTableHeader().setResizingAllowed(false);
        tblBookingDetail.getTableHeader().setReorderingAllowed(false);
        spnlTblBookingDetail.setViewportView(tblBookingDetail);
        if (tblBookingDetail.getColumnModel().getColumnCount() > 0) {
            tblBookingDetail.getColumnModel().getColumn(0).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(0).setPreferredWidth(39);
            tblBookingDetail.getColumnModel().getColumn(1).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblBookingDetail.getColumnModel().getColumn(2).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblBookingDetail.getColumnModel().getColumn(3).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblBookingDetail.getColumnModel().getColumn(4).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnlTblBookingDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spnlTblBookingDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanel70.setBackground(new java.awt.Color(122, 72, 221));
        jPanel70.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel70.setPreferredSize(new java.awt.Dimension(530, 22));

        jLabel108.setBackground(new java.awt.Color(255, 255, 255));
        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("Chi phí dịch vụ");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(80, 80, 80));
        jLabel109.setText("Tổng cộng:");

        lbTotal2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal2.setForeground(new java.awt.Color(80, 80, 80));
        lbTotal2.setPreferredSize(new java.awt.Dimension(368, 20));

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(lbTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBookingDetailHeader.setBackground(new java.awt.Color(122, 72, 221));
        pnlBookingDetailHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBookingDetailHeaderMouseDragged(evt);
            }
        });
        pnlBookingDetailHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBookingDetailHeaderMousePressed(evt);
            }
        });

        lbCloseDialogBookingDetaill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogBookingDetaill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogBookingDetaill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCloseDialogBookingDetaill.setPreferredSize(new java.awt.Dimension(24, 24));
        lbCloseDialogBookingDetaill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogBookingDetaillMousePressed(evt);
            }
        });

        lbBookingDetaillTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBookingDetaillTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbBookingDetaillTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBookingDetaillTitle.setText("Chi tiết đặt phòng");

        javax.swing.GroupLayout pnlBookingDetailHeaderLayout = new javax.swing.GroupLayout(pnlBookingDetailHeader);
        pnlBookingDetailHeader.setLayout(pnlBookingDetailHeaderLayout);
        pnlBookingDetailHeaderLayout.setHorizontalGroup(
            pnlBookingDetailHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingDetailHeaderLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lbBookingDetaillTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCloseDialogBookingDetaill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBookingDetailHeaderLayout.setVerticalGroup(
            pnlBookingDetailHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingDetailHeaderLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lbCloseDialogBookingDetaill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(lbBookingDetaillTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(pnlBookingDetailHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(pnlBookingDetailHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout dialogBookingDetailLayout = new javax.swing.GroupLayout(dialogBookingDetail.getContentPane());
        dialogBookingDetail.getContentPane().setLayout(dialogBookingDetailLayout);
        dialogBookingDetailLayout.setHorizontalGroup(
            dialogBookingDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogBookingDetailLayout.setVerticalGroup(
            dialogBookingDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogBookingInfo.setMinimumSize(new java.awt.Dimension(504, 568));
        dialogBookingInfo.setModal(true);
        dialogBookingInfo.setUndecorated(true);
        dialogBookingInfo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingInfoOverlay.setBackground(new Color(0,0,0,80));

        javax.swing.GroupLayout bookingInfoOverlayLayout = new javax.swing.GroupLayout(bookingInfoOverlay);
        bookingInfoOverlay.setLayout(bookingInfoOverlayLayout);
        bookingInfoOverlayLayout.setHorizontalGroup(
            bookingInfoOverlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        bookingInfoOverlayLayout.setVerticalGroup(
            bookingInfoOverlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        dialogBookingInfo.getContentPane().add(bookingInfoOverlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setPreferredSize(new java.awt.Dimension(504, 568));

        pnlBookingInfoHeader.setBackground(new java.awt.Color(122, 72, 221));
        pnlBookingInfoHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBookingInfoHeaderMouseDragged(evt);
            }
        });
        pnlBookingInfoHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBookingInfoHeaderMousePressed(evt);
            }
        });

        lbCloseDialogBookingInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCloseDialogBookingInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closewhite20.png"))); // NOI18N
        lbCloseDialogBookingInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCloseDialogBookingInfo.setPreferredSize(new java.awt.Dimension(24, 24));
        lbCloseDialogBookingInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbCloseDialogBookingInfoMousePressed(evt);
            }
        });

        lbBookingDetaillTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbBookingDetaillTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lbBookingDetaillTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBookingDetaillTitle1.setText("Thông tin đặt phòng");

        javax.swing.GroupLayout pnlBookingInfoHeaderLayout = new javax.swing.GroupLayout(pnlBookingInfoHeader);
        pnlBookingInfoHeader.setLayout(pnlBookingInfoHeaderLayout);
        pnlBookingInfoHeaderLayout.setHorizontalGroup(
            pnlBookingInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingInfoHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBookingDetaillTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCloseDialogBookingInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBookingInfoHeaderLayout.setVerticalGroup(
            pnlBookingInfoHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingInfoHeaderLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lbCloseDialogBookingInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(lbBookingDetaillTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel119.setPreferredSize(new java.awt.Dimension(150, 15));

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel118.setText("Thông tin khách hàng");
        jLabel118.setToolTipText("");

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel120.setText("Số CMND:");
        jLabel120.setPreferredSize(new java.awt.Dimension(72, 15));

        lbCustomerIdentityCard2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbCustomerIdentityCard2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel122.setText("Họ tên:");
        jLabel122.setMaximumSize(new java.awt.Dimension(72, 15));
        jLabel122.setMinimumSize(new java.awt.Dimension(72, 15));
        jLabel122.setPreferredSize(new java.awt.Dimension(72, 15));

        lbCustomerName2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbCustomerName2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel124.setText("Giới tính:");
        jLabel124.setMaximumSize(new java.awt.Dimension(72, 15));
        jLabel124.setMinimumSize(new java.awt.Dimension(72, 15));
        jLabel124.setPreferredSize(new java.awt.Dimension(72, 15));

        lbCustomerGender2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbCustomerGender2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel126.setText("Số điện thoại:");

        lbCustomerPhone2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbCustomerPhone2.setPreferredSize(new java.awt.Dimension(150, 15));

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCustomerIdentityCard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCustomerName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCustomerGender2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel118)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCustomerPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(jLabel118)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCustomerIdentityCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCustomerName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCustomerGender2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(lbCustomerPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel128.setText("Thông tin người lập");
        jLabel128.setToolTipText("");

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel129.setText("Mã nhân viên:");
        jLabel129.setPreferredSize(new java.awt.Dimension(75, 15));

        lbUserId2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbUserId2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel131.setText("Họ tên:");
        jLabel131.setMaximumSize(new java.awt.Dimension(72, 15));
        jLabel131.setMinimumSize(new java.awt.Dimension(72, 15));
        jLabel131.setPreferredSize(new java.awt.Dimension(75, 15));

        lbUserName2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbUserName2.setPreferredSize(new java.awt.Dimension(150, 15));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel133.setText("Chức vụ:");
        jLabel133.setMaximumSize(new java.awt.Dimension(72, 15));
        jLabel133.setMinimumSize(new java.awt.Dimension(72, 15));
        jLabel133.setPreferredSize(new java.awt.Dimension(75, 15));

        lbUserRights2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbUserRights2.setPreferredSize(new java.awt.Dimension(150, 15));

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUserId2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUserName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUserRights2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel128))
                .addGap(0, 0, 0))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jLabel128)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUserId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUserName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUserRights2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel98.setText("Mã đặt phòng:");

        lbBookingId2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbBookingId2.setPreferredSize(new java.awt.Dimension(152, 14));

        spnlRoomList3.setBackground(new java.awt.Color(255, 255, 255));
        spnlRoomList3.setBorder(null);
        spnlRoomList3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlRoomList3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlRoomList3Layout = new javax.swing.GroupLayout(pnlRoomList3);
        pnlRoomList3.setLayout(pnlRoomList3Layout);
        pnlRoomList3Layout.setHorizontalGroup(
            pnlRoomList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        pnlRoomList3Layout.setVerticalGroup(
            pnlRoomList3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        spnlRoomList3.setViewportView(pnlRoomList3);

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel111.setText("Ngày nhận phòng:");

        lbCheckin2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbCheckin2.setPreferredSize(new java.awt.Dimension(157, 15));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel112.setText("Dách sách phòng");

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));

        btnPay.setText("Thanh toán");
        btnPay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPay.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnPay.setkBorderRadius(35);
        btnPay.setkEndColor(new java.awt.Color(122, 72, 221));
        btnPay.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnPay.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnPay.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnPay.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnPay.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnPay.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnPay.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnPay.setkStartColor(new java.awt.Color(122, 72, 221));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnCancelBook.setText("Hủy đặt phòng");
        btnCancelBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelBook.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkBorderRadius(35);
        btnCancelBook.setkEndColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnCancelBook.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.setkStartColor(new java.awt.Color(122, 72, 221));
        btnCancelBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBookActionPerformed(evt);
            }
        });

        btnGetRoom.setText("Nhận phòng");
        btnGetRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGetRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkBorderRadius(35);
        btnGetRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkHoverColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnGetRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnGetRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelBook, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGetRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnlRoomList3)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel73Layout.createSequentialGroup()
                                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel73Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbBookingId2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel73Layout.createSequentialGroup()
                                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel73Layout.createSequentialGroup()
                                .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCheckin2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel98)
                        .addComponent(lbBookingId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel111)
                        .addComponent(lbCheckin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel112)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnlRoomList3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBookingInfoHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addComponent(pnlBookingInfoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogBookingInfo.getContentPane().add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 579));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1092, 614));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainOverLay.setBackground(new Color(0,0,0,80));

        javax.swing.GroupLayout mainOverLayLayout = new javax.swing.GroupLayout(mainOverLay);
        mainOverLay.setLayout(mainOverLayLayout);
        mainOverLayLayout.setHorizontalGroup(
            mainOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        mainOverLayLayout.setVerticalGroup(
            mainOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        getContentPane().add(mainOverLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bg.setkBorderRadius(0);
        bg.setkEndColor(new java.awt.Color(255, 255, 255));
        bg.setkStartColor(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(1092, 614));
        bg.setPreferredSize(new java.awt.Dimension(1092, 614));

        jPanel1.setBackground(new java.awt.Color(64, 33, 89));
        jPanel1.setMinimumSize(new java.awt.Dimension(273, 614));
        jPanel1.setPreferredSize(new java.awt.Dimension(273, 614));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Hotel Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));

        pnlOpenPnlCard11.setBackground(new java.awt.Color(85, 65, 118));
        pnlOpenPnlCard11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOpenPnlCard11.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard11.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpenPnlCard11MousePressed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/dashboardgray18.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Dashboard");

        javax.swing.GroupLayout pnlOpenPnlCard11Layout = new javax.swing.GroupLayout(pnlOpenPnlCard11);
        pnlOpenPnlCard11.setLayout(pnlOpenPnlCard11Layout);
        pnlOpenPnlCard11Layout.setHorizontalGroup(
            pnlOpenPnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard11Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
        );
        pnlOpenPnlCard11Layout.setVerticalGroup(
            pnlOpenPnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard11Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlOpenPnlCard11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenPnlCard12.setBackground(new java.awt.Color(64, 43, 100));
        pnlOpenPnlCard12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOpenPnlCard12.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard12.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpenPnlCard12MousePressed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/room18gray.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Quản lý phòng");

        javax.swing.GroupLayout pnlOpenPnlCard12Layout = new javax.swing.GroupLayout(pnlOpenPnlCard12);
        pnlOpenPnlCard12.setLayout(pnlOpenPnlCard12Layout);
        pnlOpenPnlCard12Layout.setHorizontalGroup(
            pnlOpenPnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard12Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpenPnlCard12Layout.setVerticalGroup(
            pnlOpenPnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard12Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlOpenPnlCard12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenPnlCard13.setBackground(new java.awt.Color(64, 43, 100));
        pnlOpenPnlCard13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOpenPnlCard13.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard13.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpenPnlCard13MousePressed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/booking18gray.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Quản lý đặt phòng");

        javax.swing.GroupLayout pnlOpenPnlCard13Layout = new javax.swing.GroupLayout(pnlOpenPnlCard13);
        pnlOpenPnlCard13.setLayout(pnlOpenPnlCard13Layout);
        pnlOpenPnlCard13Layout.setHorizontalGroup(
            pnlOpenPnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard13Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpenPnlCard13Layout.setVerticalGroup(
            pnlOpenPnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard13Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlOpenPnlCard13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenPnlCard14.setBackground(new java.awt.Color(64, 43, 100));
        pnlOpenPnlCard14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOpenPnlCard14.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard14.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpenPnlCard14MousePressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/service18gray.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Quản lý dịch vụ");

        javax.swing.GroupLayout pnlOpenPnlCard14Layout = new javax.swing.GroupLayout(pnlOpenPnlCard14);
        pnlOpenPnlCard14.setLayout(pnlOpenPnlCard14Layout);
        pnlOpenPnlCard14Layout.setHorizontalGroup(
            pnlOpenPnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard14Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpenPnlCard14Layout.setVerticalGroup(
            pnlOpenPnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard14Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlOpenPnlCard14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpenPnlCard15.setBackground(new java.awt.Color(64, 43, 100));
        pnlOpenPnlCard15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlOpenPnlCard15.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard15.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlOpenPnlCard15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpenPnlCard15MousePressed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/customer18gray.png"))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Quản lí khách hàng");

        javax.swing.GroupLayout pnlOpenPnlCard15Layout = new javax.swing.GroupLayout(pnlOpenPnlCard15);
        pnlOpenPnlCard15.setLayout(pnlOpenPnlCard15Layout);
        pnlOpenPnlCard15Layout.setHorizontalGroup(
            pnlOpenPnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard15Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpenPnlCard15Layout.setVerticalGroup(
            pnlOpenPnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenPnlCard15Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlOpenPnlCard15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSignOut.setBackground(new java.awt.Color(63, 33, 89));
        pnlSignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSignOut.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlSignOut.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSignOutMousePressed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/signout18gray.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Đăng xuất");

        javax.swing.GroupLayout pnlSignOutLayout = new javax.swing.GroupLayout(pnlSignOut);
        pnlSignOut.setLayout(pnlSignOutLayout);
        pnlSignOutLayout.setHorizontalGroup(
            pnlSignOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignOutLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSignOutLayout.setVerticalGroup(
            pnlSignOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignOutLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlSignOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSetting.setBackground(new java.awt.Color(63, 33, 89));
        pnlSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlSetting.setMinimumSize(new java.awt.Dimension(273, 49));
        pnlSetting.setPreferredSize(new java.awt.Dimension(273, 49));
        pnlSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSettingMousePressed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/settinggray18.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Cài đặt");

        javax.swing.GroupLayout pnlSettingLayout = new javax.swing.GroupLayout(pnlSetting);
        pnlSetting.setLayout(pnlSettingLayout);
        pnlSettingLayout.setHorizontalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSettingLayout.setVerticalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(pnlOpenPnlCard11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlOpenPnlCard12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpenPnlCard13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpenPnlCard14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpenPnlCard15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSignOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSetting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlOpenPnlCard11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlOpenPnlCard12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlOpenPnlCard13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlOpenPnlCard14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlOpenPnlCard15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(819, 614));
        jPanel9.setPreferredSize(new java.awt.Dimension(819, 614));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setMinimumSize(new java.awt.Dimension(819, 559));
        jPanel11.setPreferredSize(new java.awt.Dimension(819, 559));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rightSideOverLay.setBackground(new Color(255,255,255,200));

        javax.swing.GroupLayout rightSideOverLayLayout = new javax.swing.GroupLayout(rightSideOverLay);
        rightSideOverLay.setLayout(rightSideOverLayLayout);
        rightSideOverLayLayout.setHorizontalGroup(
            rightSideOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        rightSideOverLayLayout.setVerticalGroup(
            rightSideOverLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jPanel11.add(rightSideOverLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlCards1.setBackground(new java.awt.Color(255, 255, 255));
        pnlCards1.setMinimumSize(new java.awt.Dimension(819, 559));
        pnlCards1.setPreferredSize(new java.awt.Dimension(819, 559));
        pnlCards1.setLayout(new java.awt.CardLayout());

        pnlCard11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlCard11Layout = new javax.swing.GroupLayout(pnlCard11);
        pnlCard11.setLayout(pnlCard11Layout);
        pnlCard11Layout.setHorizontalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        pnlCard11Layout.setVerticalGroup(
            pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        pnlCards1.add(pnlCard11, "pnlCard11");

        pnlCard12.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard12.setMinimumSize(new java.awt.Dimension(819, 559));
        pnlCard12.setPreferredSize(new java.awt.Dimension(819, 559));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setPreferredSize(new java.awt.Dimension(155, 35));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/pluswhite17.png"))); // NOI18N
        jLabel36.setText("Thêm phòng mới");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel31.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        btnAddRoom.setBackground(new Color(0,0,0,0));
        btnAddRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkBorderRadius(25);
        btnAddRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnAddRoom.setPreferredSize(new java.awt.Dimension(152, 30));
        btnAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoomActionPerformed(evt);
            }
        });
        jPanel31.add(btnAddRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel37.setText("Danh sách phòng");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tầng:");

        cbbFilterFloor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbFilterFloor.setMinimumSize(new java.awt.Dimension(90, 26));
        cbbFilterFloor.setPreferredSize(new java.awt.Dimension(90, 26));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Loại phòng:");

        cbbFilterRoomType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Tình trạng:");

        cbbFilterStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbFilterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Đang sử dụng", "Đặt trước", "Đang dọn dẹp" }));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setPreferredSize(new java.awt.Dimension(71, 28));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/filterwhite17.png"))); // NOI18N
        jLabel40.setText("Lọc");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.setPreferredSize(new java.awt.Dimension(60, 28));
        jPanel35.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnFilterRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkBorderRadius(25);
        btnFilterRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnFilterRoom.setPreferredSize(new java.awt.Dimension(80, 28));
        btnFilterRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterRoomActionPerformed(evt);
            }
        });
        jPanel35.add(btnFilterRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setPreferredSize(new java.awt.Dimension(78, 28));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/searchwhite17.png"))); // NOI18N
        jLabel45.setText("Tìm");
        jLabel45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel45.setPreferredSize(new java.awt.Dimension(60, 28));
        jPanel38.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnSearchRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkBorderRadius(25);
        btnSearchRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnSearchRoom.setPreferredSize(new java.awt.Dimension(80, 28));
        btnSearchRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRoomActionPerformed(evt);
            }
        });
        jPanel38.add(btnSearchRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel46.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 109, 109))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFilterFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFilterRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFilterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSearchRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbFilterFloor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbFilterRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbFilterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );

        spnlRoomList.setBackground(new java.awt.Color(235, 246, 250));
        spnlRoomList.setBorder(null);
        spnlRoomList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlRoomList.setPreferredSize(new java.awt.Dimension(819, 420));

        pnlRoomList.setBackground(new java.awt.Color(235, 246, 250));
        pnlRoomList.setPreferredSize(new java.awt.Dimension(819, 420));

        javax.swing.GroupLayout pnlRoomListLayout = new javax.swing.GroupLayout(pnlRoomList);
        pnlRoomList.setLayout(pnlRoomListLayout);
        pnlRoomListLayout.setHorizontalGroup(
            pnlRoomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        pnlRoomListLayout.setVerticalGroup(
            pnlRoomListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        spnlRoomList.setViewportView(pnlRoomList);

        javax.swing.GroupLayout pnlCard12Layout = new javax.swing.GroupLayout(pnlCard12);
        pnlCard12.setLayout(pnlCard12Layout);
        pnlCard12Layout.setHorizontalGroup(
            pnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(spnlRoomList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard12Layout.setVerticalGroup(
            pnlCard12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard12Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlRoomList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards1.add(pnlCard12, "pnlCard12");

        pnlCard13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel16.setPreferredSize(new java.awt.Dimension(819, 125));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel23.setText("Quản lý đặt phòng");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setMinimumSize(new java.awt.Dimension(779, 32));
        jPanel39.setPreferredSize(new java.awt.Dimension(779, 32));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/booking17white.png"))); // NOI18N
        jLabel50.setText(" Đặt phòng");
        jLabel50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel39.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        btnBookRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnBookRoom.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkBorderRadius(25);
        btnBookRoom.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookRoom.setPreferredSize(new java.awt.Dimension(152, 30));
        btnBookRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookRoomActionPerformed(evt);
            }
        });
        jPanel39.add(btnBookRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.setMinimumSize(new java.awt.Dimension(95, 32));
        jPanel12.setPreferredSize(new java.awt.Dimension(95, 32));

        lbOpenCard21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbOpenCard21.setForeground(new java.awt.Color(122, 72, 221));
        lbOpenCard21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOpenCard21.setText("Đặt trước");
        lbOpenCard21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(122, 72, 221)));
        lbOpenCard21.setMaximumSize(new java.awt.Dimension(95, 32));
        lbOpenCard21.setMinimumSize(new java.awt.Dimension(95, 32));
        lbOpenCard21.setPreferredSize(new java.awt.Dimension(95, 32));
        lbOpenCard21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOpenCard21MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(lbOpenCard21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbOpenCard21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.setMinimumSize(new java.awt.Dimension(120, 32));
        jPanel18.setPreferredSize(new java.awt.Dimension(120, 32));

        lbOpenCard22.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbOpenCard22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOpenCard22.setText("Đang sử dụng");
        lbOpenCard22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOpenCard22MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbOpenCard22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbOpenCard22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.setMinimumSize(new java.awt.Dimension(140, 32));
        jPanel20.setPreferredSize(new java.awt.Dimension(140, 32));

        lbOpenCard23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbOpenCard23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOpenCard23.setText("Lịch sử đặt phòng");
        lbOpenCard23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbOpenCard23MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbOpenCard23, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbOpenCard23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );

        pnlCards2.setBackground(new java.awt.Color(255, 255, 255));
        pnlCards2.setMinimumSize(new java.awt.Dimension(819, 434));
        pnlCards2.setPreferredSize(new java.awt.Dimension(819, 434));
        pnlCards2.setLayout(new java.awt.CardLayout());

        pnlCard21.setBackground(new java.awt.Color(235, 246, 250));
        pnlCard21.setMinimumSize(new java.awt.Dimension(819, 434));

        jPanel53.setBackground(new java.awt.Color(235, 246, 250));

        kGradientPanel6.setBackground(new java.awt.Color(235, 246, 250));
        kGradientPanel6.setkBorderRadius(25);
        kGradientPanel6.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchBooking5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearchBooking5.setForeground(new java.awt.Color(100, 100, 100));
        txtSearchBooking5.setText("Số CMND hoặc tên khách hàng");
        txtSearchBooking5.setBorder(null);
        txtSearchBooking5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchBooking5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchBooking5FocusLost(evt);
            }
        });
        txtSearchBooking5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBooking5KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchBooking5, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(txtSearchBooking5)
        );

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        spnlPreBook.setBackground(new java.awt.Color(255, 255, 255));
        spnlPreBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        spnlPreBook.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlPreBook.setPreferredSize(new java.awt.Dimension(779, 377));

        tblPreBook.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblPreBook.setForeground(new java.awt.Color(51, 51, 51));
        tblPreBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã đặt phòng", "Thông tin khách hàng", "Nhận phòng", "Người tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPreBook.setGridColor(new java.awt.Color(235, 246, 250));
        tblPreBook.setRowHeight(60);
        tblPreBook.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblPreBook.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPreBook.getTableHeader().setResizingAllowed(false);
        tblPreBook.getTableHeader().setReorderingAllowed(false);
        tblPreBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPreBookMouseClicked(evt);
            }
        });
        spnlPreBook.setViewportView(tblPreBook);
        if (tblPreBook.getColumnModel().getColumnCount() > 0) {
            tblPreBook.getColumnModel().getColumn(0).setResizable(false);
            tblPreBook.getColumnModel().getColumn(0).setPreferredWidth(79);
            tblPreBook.getColumnModel().getColumn(1).setResizable(false);
            tblPreBook.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblPreBook.getColumnModel().getColumn(2).setResizable(false);
            tblPreBook.getColumnModel().getColumn(2).setPreferredWidth(220);
            tblPreBook.getColumnModel().getColumn(3).setResizable(false);
            tblPreBook.getColumnModel().getColumn(3).setPreferredWidth(160);
            tblPreBook.getColumnModel().getColumn(4).setResizable(false);
            tblPreBook.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout pnlCard21Layout = new javax.swing.GroupLayout(pnlCard21);
        pnlCard21.setLayout(pnlCard21Layout);
        pnlCard21Layout.setHorizontalGroup(
            pnlCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard21Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(spnlPreBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlCard21Layout.setVerticalGroup(
            pnlCard21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard21Layout.createSequentialGroup()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlPreBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCards2.add(pnlCard21, "pnlCard21");

        pnlCard22.setBackground(new java.awt.Color(235, 246, 250));

        jPanel26.setBackground(new java.awt.Color(235, 246, 250));

        kGradientPanel5.setBackground(new java.awt.Color(235, 246, 250));
        kGradientPanel5.setkBorderRadius(25);
        kGradientPanel5.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchBooking4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearchBooking4.setForeground(new java.awt.Color(100, 100, 100));
        txtSearchBooking4.setText("Số CMND hoặc tên khách hàng");
        txtSearchBooking4.setBorder(null);
        txtSearchBooking4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchBooking4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchBooking4FocusLost(evt);
            }
        });
        txtSearchBooking4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBooking4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchBooking4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(txtSearchBooking4)
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        spnlUsing.setBackground(new java.awt.Color(255, 255, 255));
        spnlUsing.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        spnlUsing.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlUsing.setPreferredSize(new java.awt.Dimension(779, 377));

        tblUsing.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblUsing.setForeground(new java.awt.Color(51, 51, 51));
        tblUsing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã đặt phòng", "Thông tin khách hàng", "Nhận phòng", "Người tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsing.setGridColor(new java.awt.Color(235, 246, 250));
        tblUsing.setRowHeight(60);
        tblUsing.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblUsing.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUsing.getTableHeader().setResizingAllowed(false);
        tblUsing.getTableHeader().setReorderingAllowed(false);
        tblUsing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsingMouseClicked(evt);
            }
        });
        spnlUsing.setViewportView(tblUsing);
        if (tblUsing.getColumnModel().getColumnCount() > 0) {
            tblUsing.getColumnModel().getColumn(0).setResizable(false);
            tblUsing.getColumnModel().getColumn(0).setPreferredWidth(79);
            tblUsing.getColumnModel().getColumn(1).setResizable(false);
            tblUsing.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblUsing.getColumnModel().getColumn(2).setResizable(false);
            tblUsing.getColumnModel().getColumn(2).setPreferredWidth(220);
            tblUsing.getColumnModel().getColumn(3).setResizable(false);
            tblUsing.getColumnModel().getColumn(3).setPreferredWidth(160);
            tblUsing.getColumnModel().getColumn(4).setResizable(false);
            tblUsing.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout pnlCard22Layout = new javax.swing.GroupLayout(pnlCard22);
        pnlCard22.setLayout(pnlCard22Layout);
        pnlCard22Layout.setHorizontalGroup(
            pnlCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(spnlUsing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlCard22Layout.setVerticalGroup(
            pnlCard22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard22Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlUsing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCards2.add(pnlCard22, "pnlCard22");

        pnlCard23.setBackground(new java.awt.Color(235, 246, 250));

        jPanel25.setBackground(new java.awt.Color(235, 246, 250));

        kGradientPanel4.setBackground(new java.awt.Color(235, 246, 250));
        kGradientPanel4.setkBorderRadius(25);
        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/search.png"))); // NOI18N

        txtSearchBooking3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtSearchBooking3.setForeground(new java.awt.Color(100, 100, 100));
        txtSearchBooking3.setText("Số CMND hoặc tên khách hàng");
        txtSearchBooking3.setBorder(null);
        txtSearchBooking3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchBooking3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchBooking3FocusLost(evt);
            }
        });
        txtSearchBooking3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBooking3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchBooking3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(txtSearchBooking3)
        );

        cbbBookingHistoryMonth.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cbbBookingHistoryMonth.setYearChooser(cbbBookingHistoryYear);
        cbbBookingHistoryMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbbBookingHistoryMonthPropertyChange(evt);
            }
        });

        cbbBookingHistoryYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbbBookingHistoryYearPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbbBookingHistoryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbBookingHistoryYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbBookingHistoryYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbBookingHistoryMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        spnlBookingHistory.setBackground(new java.awt.Color(255, 255, 255));
        spnlBookingHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        spnlBookingHistory.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlBookingHistory.setPreferredSize(new java.awt.Dimension(779, 377));

        tblBookingHistory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblBookingHistory.setForeground(new java.awt.Color(51, 51, 51));
        tblBookingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã đặt phòng", "Thông tin khách hàng", "Nhận phòng", "Trả phòng", "Người tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookingHistory.setGridColor(new java.awt.Color(235, 246, 250));
        tblBookingHistory.setRowHeight(60);
        tblBookingHistory.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblBookingHistory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBookingHistory.getTableHeader().setResizingAllowed(false);
        tblBookingHistory.getTableHeader().setReorderingAllowed(false);
        tblBookingHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingHistoryMouseClicked(evt);
            }
        });
        spnlBookingHistory.setViewportView(tblBookingHistory);
        if (tblBookingHistory.getColumnModel().getColumnCount() > 0) {
            tblBookingHistory.getColumnModel().getColumn(0).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(0).setPreferredWidth(59);
            tblBookingHistory.getColumnModel().getColumn(1).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBookingHistory.getColumnModel().getColumn(2).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblBookingHistory.getColumnModel().getColumn(3).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblBookingHistory.getColumnModel().getColumn(4).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblBookingHistory.getColumnModel().getColumn(5).setResizable(false);
            tblBookingHistory.getColumnModel().getColumn(5).setPreferredWidth(180);
        }

        javax.swing.GroupLayout pnlCard23Layout = new javax.swing.GroupLayout(pnlCard23);
        pnlCard23.setLayout(pnlCard23Layout);
        pnlCard23Layout.setHorizontalGroup(
            pnlCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnlBookingHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlCard23Layout.setVerticalGroup(
            pnlCard23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard23Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlBookingHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCards2.add(pnlCard23, "pnlCard23");

        javax.swing.GroupLayout pnlCard13Layout = new javax.swing.GroupLayout(pnlCard13);
        pnlCard13.setLayout(pnlCard13Layout);
        pnlCard13Layout.setHorizontalGroup(
            pnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCards2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard13Layout.setVerticalGroup(
            pnlCard13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard13Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCards2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards1.add(pnlCard13, "pnlCard13");

        pnlCard14.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard14.setPreferredSize(new java.awt.Dimension(819, 559));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel21.setMinimumSize(new java.awt.Dimension(819, 134));
        jPanel21.setPreferredSize(new java.awt.Dimension(819, 134));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel24.setText("Quản lý dịch vụ");
        jLabel24.setPreferredSize(new java.awt.Dimension(779, 32));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setMinimumSize(new java.awt.Dimension(779, 32));
        jPanel40.setPreferredSize(new java.awt.Dimension(779, 32));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/pluswhite17.png"))); // NOI18N
        jLabel51.setText(" Thêm dịch vụ");
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel40.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        btnAddService.setBackground(new Color(0,0,0,0));
        btnAddService.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkBorderRadius(25);
        btnAddService.setkEndColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnAddService.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnAddService.setkStartColor(new java.awt.Color(122, 72, 221));
        btnAddService.setPreferredSize(new java.awt.Dimension(152, 30));
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });
        jPanel40.add(btnAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setMinimumSize(new java.awt.Dimension(779, 32));
        jPanel41.setPreferredSize(new java.awt.Dimension(779, 32));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/booking17white.png"))); // NOI18N
        jLabel52.setText(" Đặt dịch vụ");
        jLabel52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel41.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        btnBookService.setBackground(new Color(0,0,0,0));
        btnBookService.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkBorderRadius(25);
        btnBookService.setkEndColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnBookService.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnBookService.setkStartColor(new java.awt.Color(122, 72, 221));
        btnBookService.setPreferredSize(new java.awt.Dimension(152, 30));
        btnBookService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookServiceActionPerformed(evt);
            }
        });
        jPanel41.add(btnBookService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Sắp xếp theo:");
        jLabel53.setMaximumSize(new java.awt.Dimension(82, 28));
        jLabel53.setMinimumSize(new java.awt.Dimension(82, 28));
        jLabel53.setPreferredSize(new java.awt.Dimension(82, 28));

        cbbServiceSort.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbServiceSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giá tăng dần", "Giá giảm dần" }));
        cbbServiceSort.setPreferredSize(new java.awt.Dimension(150, 28));

        cbbServiceStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbServiceStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Vẫn còn", "Đã hết" }));
        cbbServiceStatus.setPreferredSize(new java.awt.Dimension(120, 28));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Trạng thái:");
        jLabel54.setMaximumSize(new java.awt.Dimension(65, 28));
        jLabel54.setMinimumSize(new java.awt.Dimension(65, 28));
        jLabel54.setPreferredSize(new java.awt.Dimension(65, 28));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setPreferredSize(new java.awt.Dimension(71, 28));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/filterwhite17.png"))); // NOI18N
        jLabel55.setText("Lọc");
        jLabel55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel55.setPreferredSize(new java.awt.Dimension(60, 28));
        jPanel42.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnFilterService.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkBorderRadius(25);
        btnFilterService.setkEndColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnFilterService.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setkStartColor(new java.awt.Color(122, 72, 221));
        btnFilterService.setPreferredSize(new java.awt.Dimension(80, 28));
        btnFilterService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterServiceActionPerformed(evt);
            }
        });
        jPanel42.add(btnFilterService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Tìm kiếm:");
        jLabel56.setMaximumSize(new java.awt.Dimension(58, 28));
        jLabel56.setMinimumSize(new java.awt.Dimension(58, 28));
        jLabel56.setPreferredSize(new java.awt.Dimension(58, 28));

        txtSearchService.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchService.setPreferredSize(new java.awt.Dimension(163, 28));
        txtSearchService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchServiceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbServiceSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbServiceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchService, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbServiceStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbServiceSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spnlServiceList.setBackground(new java.awt.Color(255, 255, 255));
        spnlServiceList.setBorder(null);
        spnlServiceList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spnlServiceList.setMinimumSize(new java.awt.Dimension(819, 425));
        spnlServiceList.setPreferredSize(new java.awt.Dimension(819, 425));

        pnlServiceList.setBackground(new java.awt.Color(235, 246, 250));
        pnlServiceList.setMinimumSize(new java.awt.Dimension(819, 425));

        javax.swing.GroupLayout pnlServiceListLayout = new javax.swing.GroupLayout(pnlServiceList);
        pnlServiceList.setLayout(pnlServiceListLayout);
        pnlServiceListLayout.setHorizontalGroup(
            pnlServiceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        pnlServiceListLayout.setVerticalGroup(
            pnlServiceListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        spnlServiceList.setViewportView(pnlServiceList);

        javax.swing.GroupLayout pnlCard14Layout = new javax.swing.GroupLayout(pnlCard14);
        pnlCard14.setLayout(pnlCard14Layout);
        pnlCard14Layout.setHorizontalGroup(
            pnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard14Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(spnlServiceList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard14Layout.setVerticalGroup(
            pnlCard14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard14Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(spnlServiceList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards1.add(pnlCard14, "pnlCard14");

        pnlCard15.setBackground(new java.awt.Color(235, 246, 250));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel23.setMinimumSize(new java.awt.Dimension(819, 134));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel63.setText("Quản lý khách hàng");
        jLabel63.setPreferredSize(new java.awt.Dimension(779, 32));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setMinimumSize(new java.awt.Dimension(779, 32));
        jPanel49.setPreferredSize(new java.awt.Dimension(779, 32));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/pluswhite17.png"))); // NOI18N
        jLabel64.setText(" Thêm khách hàng");
        jLabel64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel49.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        btnAddCustomer.setBackground(new Color(0,0,0,0));
        btnAddCustomer.setkBackGroundColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkBorderRadius(25);
        btnAddCustomer.setkEndColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkHoverEndColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkHoverForeGround(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkHoverStartColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkIndicatorColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkPressedColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkSelectedColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setkStartColor(new java.awt.Color(122, 72, 221));
        btnAddCustomer.setPreferredSize(new java.awt.Dimension(152, 30));
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        jPanel49.add(btnAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setText("Tìm kiếm:");
        jLabel69.setMaximumSize(new java.awt.Dimension(58, 28));
        jLabel69.setMinimumSize(new java.awt.Dimension(58, 28));
        jLabel69.setPreferredSize(new java.awt.Dimension(58, 28));

        txtSearchCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchCustomer.setPreferredSize(new java.awt.Dimension(163, 28));
        txtSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCustomerKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        spnlCustomerList.setBackground(new java.awt.Color(255, 255, 255));
        spnlCustomerList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        spnlCustomerList.setPreferredSize(new java.awt.Dimension(779, 416));

        tblCustomerList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblCustomerList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblCustomerList.setForeground(new java.awt.Color(80, 80, 80));
        tblCustomerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Số chứng minh", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomerList.setGridColor(new java.awt.Color(255, 255, 255));
        tblCustomerList.setRowHeight(30);
        tblCustomerList.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tblCustomerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCustomerList.getTableHeader().setResizingAllowed(false);
        tblCustomerList.getTableHeader().setReorderingAllowed(false);
        tblCustomerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCustomerListMouseReleased(evt);
            }
        });
        spnlCustomerList.setViewportView(tblCustomerList);
        if (tblCustomerList.getColumnModel().getColumnCount() > 0) {
            tblCustomerList.getColumnModel().getColumn(0).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblCustomerList.getColumnModel().getColumn(1).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblCustomerList.getColumnModel().getColumn(2).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblCustomerList.getColumnModel().getColumn(3).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblCustomerList.getColumnModel().getColumn(4).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblCustomerList.getColumnModel().getColumn(5).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblCustomerList.getColumnModel().getColumn(6).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(6).setPreferredWidth(120);
        }

        javax.swing.GroupLayout pnlCard15Layout = new javax.swing.GroupLayout(pnlCard15);
        pnlCard15.setLayout(pnlCard15Layout);
        pnlCard15Layout.setHorizontalGroup(
            pnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCard15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(spnlCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCard15Layout.setVerticalGroup(
            pnlCard15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCard15Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnlCustomerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCards1.add(pnlCard15, "pnlCard15");

        jPanel11.add(pnlCards1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlHeader.setBackground(new Color(0,0,0,0));
        pnlHeader.setMinimumSize(new java.awt.Dimension(819, 55));
        pnlHeader.setPreferredSize(new java.awt.Dimension(819, 55));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        pnlCloseWelcome.setBackground(new Color(0,0,0,0));
        pnlCloseWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCloseWelcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCloseWelcomeMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/closegray25.png"))); // NOI18N

        javax.swing.GroupLayout pnlCloseWelcomeLayout = new javax.swing.GroupLayout(pnlCloseWelcome);
        pnlCloseWelcome.setLayout(pnlCloseWelcomeLayout);
        pnlCloseWelcomeLayout.setHorizontalGroup(
            pnlCloseWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCloseWelcomeLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        pnlCloseWelcomeLayout.setVerticalGroup(
            pnlCloseWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMinimizeWelcome.setBackground(new Color(0,0,0,0));
        pnlMinimizeWelcome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMinimizeWelcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMinimizeWelcomeMousePressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/minusgray22.png"))); // NOI18N

        javax.swing.GroupLayout pnlMinimizeWelcomeLayout = new javax.swing.GroupLayout(pnlMinimizeWelcome);
        pnlMinimizeWelcome.setLayout(pnlMinimizeWelcomeLayout);
        pnlMinimizeWelcomeLayout.setHorizontalGroup(
            pnlMinimizeWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMinimizeWelcomeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        pnlMinimizeWelcomeLayout.setVerticalGroup(
            pnlMinimizeWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new Color(0,0,0,0));
        jPanel6.setPreferredSize(new java.awt.Dimension(327, 55));

        test20.setBackground(new Color(0,0,0,0));
        test20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel24.setBackground(new Color(0,0,0,0));
        kGradientPanel24.setkBorderRadius(12);
        kGradientPanel24.setkEndColor(new java.awt.Color(51, 255, 51));
        kGradientPanel24.setkStartColor(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout kGradientPanel24Layout = new javax.swing.GroupLayout(kGradientPanel24);
        kGradientPanel24.setLayout(kGradientPanel24Layout);
        kGradientPanel24Layout.setHorizontalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        kGradientPanel24Layout.setVerticalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        test20.add(kGradientPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 12, 12));

        jLabel185.setBackground(new Color(0,0,0,0));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/items/avatar44.png"))); // NOI18N
        test20.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbUserName.setBackground(new java.awt.Color(255, 255, 255));
        lbUserName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(102, 102, 102));
        lbUserName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lbRights.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbRights.setForeground(new java.awt.Color(102, 102, 102));
        lbRights.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(test20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(lbRights, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(test20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbRights, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                .addComponent(pnlMinimizeWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCloseWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCloseWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMinimizeWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addGap(0, 55, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel2 = new JPanel();
    JLabel jLabel21 = new JLabel();
    JYearChooser ycChart = new JYearChooser();
    JPanel pnlRevenueChart = new JPanel();
    JLabel jLabel113 = new JLabel();
    JPanel pnlRoomStatusChart = new JPanel();
    JPanel jPanel79 = new JPanel();
    JLabel jLabel114 = new JLabel();

    private void myInit() {
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(819, 875));
        jPanel2.setMinimumSize(new java.awt.Dimension(819, 875));
        jPanel2.setPreferredSize(new java.awt.Dimension(819, 875));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Biểu đồ doanh thu theo tháng năm");
        jLabel21.setMaximumSize(new java.awt.Dimension(300, 25));
        jLabel21.setMinimumSize(new java.awt.Dimension(300, 25));
        jLabel21.setPreferredSize(new java.awt.Dimension(300, 25));
        jPanel2.add(jLabel21);

        ycChart.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ycChart.setMinimumSize(new java.awt.Dimension(62, 25));
        ycChart.setPreferredSize(new java.awt.Dimension(62, 25));
        ycChart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ycChartPropertyChange(evt);
            }
        });
        jPanel2.add(ycChart);
        pnlRevenueChart.setBackground(new java.awt.Color(255, 255, 255));
        pnlRevenueChart.setMaximumSize(new java.awt.Dimension(779, 355));
        pnlRevenueChart.setMinimumSize(new java.awt.Dimension(779, 355));
        pnlRevenueChart.setPreferredSize(new java.awt.Dimension(779, 355));
        javax.swing.GroupLayout pnlRevenueChartLayout = new javax.swing.GroupLayout(pnlRevenueChart);
        pnlRevenueChart.setLayout(pnlRevenueChartLayout);
        pnlRevenueChartLayout.setHorizontalGroup(
                pnlRevenueChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 779, Short.MAX_VALUE)
        );
        pnlRevenueChartLayout.setVerticalGroup(
                pnlRevenueChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel2.add(pnlRevenueChart);
        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("Biểu đồ trạng thái phòng");
        jLabel113.setMaximumSize(new java.awt.Dimension(420, 25));
        jLabel113.setMinimumSize(new java.awt.Dimension(420, 25));
        jLabel113.setName(""); // NOI18N
        jLabel113.setPreferredSize(new java.awt.Dimension(420, 25));
        jPanel2.add(jLabel113);
        pnlRoomStatusChart.setBackground(new java.awt.Color(255, 255, 255));
        pnlRoomStatusChart.setMaximumSize(new java.awt.Dimension(779, 355));
        pnlRoomStatusChart.setMinimumSize(new java.awt.Dimension(779, 355));
        pnlRoomStatusChart.setPreferredSize(new java.awt.Dimension(779, 355));
        javax.swing.GroupLayout pnlRoomStatusChartLayout = new javax.swing.GroupLayout(pnlRoomStatusChart);
        pnlRoomStatusChart.setLayout(pnlRoomStatusChartLayout);
        pnlRoomStatusChartLayout.setHorizontalGroup(
                pnlRoomStatusChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 779, Short.MAX_VALUE)
        );
        pnlRoomStatusChartLayout.setVerticalGroup(
                pnlRoomStatusChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel2.add(pnlRoomStatusChart);
        jScrollPane1.setViewportView(jPanel2);
        jPanel79.setBackground(new java.awt.Color(122, 72, 221));
        jPanel79.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel79.setPreferredSize(new java.awt.Dimension(819, 55));
        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setText("Dashboard");
        jLabel114.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jLabel114.setPreferredSize(new java.awt.Dimension(779, 36));
        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
                jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel79Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel79Layout.setVerticalGroup(
                jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel79Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout pnlCard11Layout = new javax.swing.GroupLayout(pnlCard11);
        pnlCard11.setLayout(pnlCard11Layout);
        pnlCard11Layout.setHorizontalGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCard11Layout.setVerticalGroup(pnlCard11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCard11Layout.createSequentialGroup()
                        .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        pack();
    }

    private void ycChartPropertyChange(PropertyChangeEvent evt) {
        int year = ycChart.getYear();
        displayRevenueChart(year);
    }

    private void displayRevenueChart(int year) {
        LinkedList<BookingDetail> list = new LinkedList<>();
        pnlRevenueChart.removeAll();
        for (BookingDetail bd : bookingDetailList2) {
            if (bd.getBooking().getCheckout() != null) {
                Date date = new Date(bd.getBooking().getCheckout().getTime());
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (localDate.getYear() == year && bd.getBooking().getStatus() == 3) {
                    list.add(bd);
                }
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("", "Tháng", "Doanh thu (VNĐ)", createDatasetRevenueChart(list), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(779, 350));
        pnlRevenueChart.setLayout(new FlowLayout());
        pnlRevenueChart.add(chartPanel);
        pnlRevenueChart.validate();
        pnlRevenueChart.repaint();
    }

    private CategoryDataset createDatasetRevenueChart(LinkedList<BookingDetail> list) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        long diff = 0;
        long diffDays = 0;
        int roomPrice = 0;
        int[] room = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] service = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (BookingDetail bd : list) {
            Date date = new Date(bd.getBooking().getCheckout().getTime());
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            diff = bd.getBooking().getCheckout().getTime() - bd.getBooking().getCheckin().getTime();
            diffDays = (diff / (24 * 60 * 60 * 1000)) == 0L ? 1L : (diff / (24 * 60 * 60 * 1000));
            roomPrice = (int) (diffDays * bd.getRoom().getRoomType().getPrice());
            int month = localDate.getMonthValue();
            for (int i = 1; i <= 12; i++) {
                if (month == i) {
                    room[i - 1] += roomPrice;
                    service[i - 1] += (int) bd.getServicePrice();
                }
            }
        }
        for (int i = 1; i <= room.length; i++) {
            dataset.addValue(room[i - 1], "Phòng", i + "");
        }
        for (int i = 1; i <= service.length; i++) {
            dataset.addValue(service[i - 1], "Dịch vụ", i + "");
        }
        return dataset;
    }

    private void displayRoomStatusChart() {
        pnlRoomStatusChart.removeAll();
        JFreeChart pieChart = ChartFactory.createPieChart("", createDatasetRoomStatusChart(), true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(779, 350));
        pnlRoomStatusChart.setLayout(new FlowLayout());
        pnlRoomStatusChart.add(chartPanel);
        pnlRoomStatusChart.validate();
        pnlRoomStatusChart.repaint();
    }

    private PieDataset createDatasetRoomStatusChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int emptyRoom = 0;
        int usingRoom = 0;
        int bookRoom = 0;
        int cleanRoom = 0;
        for (Room r : roomList) {
            if (r.getStatus() == (short) 1) {
                emptyRoom++;
            } else if (r.getStatus() == (short) 2) {
                usingRoom++;
            } else if (r.getStatus() == (short) 3) {
                bookRoom++;
            } else if (r.getStatus() == (short) 4) {
                cleanRoom++;
            }
        }
        dataset.setValue("Trống (" + emptyRoom + ")", emptyRoom);
        dataset.setValue("Đang sử dụng(" + usingRoom + ")", usingRoom);
        dataset.setValue("Đặt trước(" + bookRoom + ")", bookRoom);
        dataset.setValue("Đang dọn dẹp(" + cleanRoom + ")", cleanRoom);
        return dataset;
    }

    private String[] getSettingFromFileConfig() {
        String hotelName = null;
        String hotelAddress = null;
        try {
            File dir = new File("config");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File f = new File("config\\config.properties");
            if (!f.exists()) {
                Properties p = new Properties();
                f.createNewFile();
                FileInputStream fin = new FileInputStream(f);
                p.load(fin);
                FileOutputStream fout = new FileOutputStream(f);
                hotelName = "Khách sạn ABC";
                hotelAddress = "39 Thợ Nhuộm, Quận Hoàn Kiếm, Hà Nội";
                p.setProperty("hotelName", hotelName);
                p.setProperty("hotelAddress", hotelAddress);
                p.store(fout, "Saved setting");
                fin.close();
                fout.close();
            } else {
                Properties p = new Properties();
                FileInputStream fin = new FileInputStream(f);
                p.load(fin);
                hotelName = p.getProperty("hotelName");
                hotelAddress = p.getProperty("hotelAddress");
                fin.close();
                if (hotelName == null) {
                    hotelName = "Khách sạn ABC";
                }
                if (hotelAddress == null) {
                    hotelAddress = "39 Thợ Nhuộm, Quận Hoàn Kiếm, Hà Nội";
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] arr = {hotelName, hotelAddress};
        return arr;
    }

    private void setBgColor(JPanel pnl) {
        pnl.setBackground(new Color(85, 65, 118));
    }

    private void resetBgColor(JPanel pnl) {
        pnl.setBackground(new Color(64, 43, 100));
    }
    private void pnlCloseWelcomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCloseWelcomeMousePressed
        System.exit(0);
    }//GEN-LAST:event_pnlCloseWelcomeMousePressed

    private void pnlMinimizeWelcomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMinimizeWelcomeMousePressed
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_pnlMinimizeWelcomeMousePressed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - (xx + 273), y - xy);
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void pnlOpenPnlCard11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpenPnlCard11MousePressed
        setBgColor(pnlOpenPnlCard11);
        resetBgColor(pnlOpenPnlCard12);
        resetBgColor(pnlOpenPnlCard13);
        resetBgColor(pnlOpenPnlCard14);
        resetBgColor(pnlOpenPnlCard15);
        if (reloadRevenueChart == 1) {
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ycChart.setYear(localDate.getYear());
            displayRevenueChart(localDate.getYear());
            reloadRevenueChart = 0;
        }
        if (reloadRoomStatusChart == 1) {
            displayRoomStatusChart();
            reloadRoomStatusChart = 0;
        }
        cardLayout1.show(pnlCards1, "pnlCard11");
    }//GEN-LAST:event_pnlOpenPnlCard11MousePressed
    private void setCbbItem(JComboBox cbb1, JComboBox cbb2, JComboBox cbb3, Floor f, RoomType t, String s, boolean isFilter) {
        cbb1.removeAllItems();
        cbb2.removeAllItems();
        LinkedList<Floor> floorList = FloorDAOImpl.getAllFloors();
        LinkedList<RoomType> roomTypeList = RoomTypeDAOImpl.getAllRoomTypes();
        if (isFilter) {
            cbb1.addItem(new Floor(0, "Tất cả"));
            cbb2.addItem(new RoomType(0, "Tất cả", 0));
        }
        for (Floor fl : floorList) {
            cbb1.addItem(fl);
        }
        for (RoomType rt : roomTypeList) {
            cbb2.addItem(rt);
        }
        if (f != null) {
            cbb1.setSelectedItem(f);
        }
        if (t != null) {
            cbb2.setSelectedItem(t);
        }
        if (s != null) {
            cbb3.setSelectedItem(s);
        }
    }

    private void pnlOpenPnlCard12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpenPnlCard12MousePressed
        Thread thr1 = new Thread() {
            @Override
            public void run() {
                setBgColor(pnlOpenPnlCard12);
                resetBgColor(pnlOpenPnlCard11);
                resetBgColor(pnlOpenPnlCard13);
                resetBgColor(pnlOpenPnlCard14);
                resetBgColor(pnlOpenPnlCard15);
                setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                spnlRoomList.getVerticalScrollBar().setUnitIncrement(16);
                if (reloadRoomList == 1) {
                    dialogLoadding.setLocationRelativeTo(pnlCards1);
                    rightSideOverLay.setVisible(true);
                    dialogLoadding.setVisible(true);
                }
            }
        };
        thr1.start();
        Thread thr2 = new Thread() {
            @Override
            public void run() {
                if (reloadRoomList == 1) {
                    displayRoomList(roomList);
                    dialogLoadding.setVisible(false);
                    rightSideOverLay.setVisible(false);
                    reloadRoomList = 0;
                }
                cardLayout1.show(pnlCards1, "pnlCard12");
            }
        };
        thr2.start();
    }//GEN-LAST:event_pnlOpenPnlCard12MousePressed

    private void pnlOpenPnlCard13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpenPnlCard13MousePressed
        setBgColor(pnlOpenPnlCard13);
        resetBgColor(pnlOpenPnlCard12);
        resetBgColor(pnlOpenPnlCard11);
        resetBgColor(pnlOpenPnlCard14);
        resetBgColor(pnlOpenPnlCard15);
        readyRoomList.clear();
        for (Room r : roomList) {
            if (r.getStatus() == (short) 1) {
                readyRoomList.add(r);
            }
        }
        spnlPreBook.getViewport().setBackground(Color.WHITE);
        createBookingList(null, null, 1);
        displayBookingList(bookingListDisplay, tblPreBook, false);
        cardLayout1.show(pnlCards1, "pnlCard13");
    }//GEN-LAST:event_pnlOpenPnlCard13MousePressed
    private void displayServiceList(LinkedList<Service> list) {
        pnlServiceList.removeAll();
        int ListSize = list.size();
        pnlServiceList.setLayout(new FlowLayout(FlowLayout.LEADING));
        if (ListSize > 0) {
            ServiceComponent[] pnl = new ServiceComponent[ListSize];
            if (ListSize % 8 == 0) {
                pnlServiceList.setPreferredSize(new Dimension(819, ListSize * 125 / 8));
                pnlServiceList.updateUI();
            } else {
                pnlServiceList.setPreferredSize(new Dimension(819, (ListSize / 8 + 1) * 125));
                pnlServiceList.updateUI();
            }
            for (int i = 0; i < ListSize; i++) {
                Service service = list.get(i);
                String name = service.getName();
                Double price = service.getPrice();
                int amount = service.getAmount();
                pnl[i] = new ServiceComponent(service);
                pnl[i].getLbRemove().setVisible(false);
                pnl[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent evt) {
                        pnlService1MouseReleased(evt);
                    }
                });
                pnlServiceList.add(pnl[i]);
                pnlServiceList.validate();
                pnlServiceList.repaint();
            }
        } else {
            JLabel lb = new JLabel(" Không có dịch vụ nào!");
            lb.setForeground(Color.red);
            lb.setFont(new java.awt.Font("Segoe UI", 1, 24));
            pnlServiceList.add(lb);
            pnlServiceList.validate();
            pnlServiceList.repaint();
        }
    }

    private void pnlService1MouseReleased(MouseEvent evt) {
        ServiceComponent pnl = (ServiceComponent) evt.getComponent();
        if (preSelectedService == null) {
            preSelectedService = pnl;
        } else {
            preSelectedService.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
            preSelectedService = pnl;
        }
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
        if (evt.isPopupTrigger()) {
            popupService.show(pnl, evt.getX(), evt.getY());
        }
    }
    private void pnlOpenPnlCard14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpenPnlCard14MousePressed
        Thread t1 = new Thread() {
            @Override
            public void run() {
                setBgColor(pnlOpenPnlCard14);
                resetBgColor(pnlOpenPnlCard12);
                resetBgColor(pnlOpenPnlCard13);
                resetBgColor(pnlOpenPnlCard11);
                resetBgColor(pnlOpenPnlCard15);
                spnlServiceList.getVerticalScrollBar().setUnitIncrement(16);
                if (reloadServiceList == 1) {
                    dialogLoadding.setLocationRelativeTo(pnlCards1);
                    rightSideOverLay.setVisible(true);
                    dialogLoadding.setVisible(true);
                }
                cardLayout1.show(pnlCards1, "pnlCard14");
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                if (reloadServiceList == 1) {
                    Collections.sort(serviceList, new Comparator<Service>() {
                        @Override
                        public int compare(Service o1, Service o2) {
                            return (int) (o1.getPrice() - o2.getPrice());
                        }
                    });
                    displayServiceList(serviceList);
                    dialogLoadding.setVisible(false);
                    rightSideOverLay.setVisible(false);
                    reloadServiceList = 0;
                }
            }
        };
        t1.start();
        t2.start();
    }//GEN-LAST:event_pnlOpenPnlCard14MousePressed
    private void displayCustomerTable(LinkedList<Customer> list) {
        int i = 0;
        Object[][] o = new Object[list.size()][7];
        for (Customer c : list) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            o[i][0] = "  " + (i + 1) + "";
            o[i][1] = c.getIdentityCardNumber();
            o[i][2] = c.getName();
            o[i][3] = c.getGender() == 0 ? "Nam" : "Nữ";
            o[i][4] = formatter.format(c.getBirthday());
            o[i][5] = c.getPhone();
            o[i][6] = c.getEmail();
            i++;
        }
        tblCustomerList.setModel(new javax.swing.table.DefaultTableModel(
                o,
                new String[]{
                    " Stt", "Số chứng minh", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        if (tblCustomerList.getColumnModel().getColumnCount() > 0) {
            tblCustomerList.getColumnModel().getColumn(0).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblCustomerList.getColumnModel().getColumn(1).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblCustomerList.getColumnModel().getColumn(2).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblCustomerList.getColumnModel().getColumn(3).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblCustomerList.getColumnModel().getColumn(4).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblCustomerList.getColumnModel().getColumn(5).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblCustomerList.getColumnModel().getColumn(6).setResizable(false);
            tblCustomerList.getColumnModel().getColumn(6).setPreferredWidth(150);
        }
    }
    private void pnlOpenPnlCard15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpenPnlCard15MousePressed
        setBgColor(pnlOpenPnlCard15);
        resetBgColor(pnlOpenPnlCard12);
        resetBgColor(pnlOpenPnlCard13);
        resetBgColor(pnlOpenPnlCard14);
        resetBgColor(pnlOpenPnlCard11);
        spnlCustomerList.getViewport().setBackground(Color.WHITE);
        cardLayout1.show(pnlCards1, "pnlCard15");
        displayCustomerTable(customerList);
    }//GEN-LAST:event_pnlOpenPnlCard15MousePressed

    private void pnlSignOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSignOutMousePressed
        lbWarningTitle.setText("Cảnh báo");
        lbWarningTitleDetail.setText("Cảnh báo đăng xuất");
        lbWarning.setText("Bạn có muốn đăng xuất không?");
        dialogWarning.setLocationRelativeTo(bg);
        mainOverLay.setVisible(true);
        dialogWarning.setVisible(true);
        int result = Integer.parseInt(lbWarningResult.getText());
        if (result == 1) {
            dispose();
            new Welcome().setVisible(true);
            Properties p = new Properties();
            try {
                File dir = new File("config");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File f = new File("config\\config.properties");
                if (!f.exists()) {
                    f.createNewFile();
                }
                FileInputStream fin = new FileInputStream(f);
                p.load(fin);
                FileOutputStream fout = new FileOutputStream(f);
                p.remove("userId");
                p.store(fout, "removed userId");
                fin.close();
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mainOverLay.setVisible(false);
        }
    }//GEN-LAST:event_pnlSignOutMousePressed

    private void fetchDataTableType() {
        tableRoomType.setRowCount(0);
        LinkedList<RoomType> rt = RoomTypeDAOImpl.getAllRoomTypes();
        if (rt.size() > 0) {
            int i = 1;
            for (RoomType t : rt) {
                String str = t.getName();
                String name = str.substring(0, 1).toUpperCase() + str.substring(1);
                DecimalFormat formatter = new DecimalFormat("#0");
                Object[] ot = {String.valueOf(i), name, formatter.format(t.getPrice())};
                tableRoomType.addRow(ot);
                i++;
            }
        }
    }

    private void displayRoomList(LinkedList<Room> arrRoom) {
        pnlRoomList.removeAll();
        int arrRoomSize = arrRoom.size();
        pnlRoomList.setLayout(new FlowLayout(FlowLayout.LEADING));
        if (arrRoomSize > 0) {
            RoomComponent[] pnl = new RoomComponent[arrRoomSize];
            if (arrRoomSize % 5 == 0) {
                pnlRoomList.setPreferredSize(new Dimension(819, arrRoomSize * 186 / 5));
                pnlRoomList.updateUI();
            } else {
                pnlRoomList.setPreferredSize(new Dimension(819, (arrRoomSize / 5 + 1) * 186));
                pnlRoomList.updateUI();
            }
            for (int i = 0; i < arrRoomSize; i++) {
                Room room = arrRoom.get(i);
                String name = room.getName();
                String type = room.getRoomType().getName();
                pnl[i] = new RoomComponent(room);
                pnl[i].getLbRemove().setVisible(false);
                if (room.getStatus() == 1 || room.getStatus() == 4) {
                    pnl[i].addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent evt) {
                            pnlType1MouseReleased(evt);
                        }
                    });
                }
                pnlRoomList.add(pnl[i]);
                pnlRoomList.validate();
                pnlRoomList.repaint();
            }
        } else {
            JLabel lb = new JLabel(" Không có phòng nào!");
            lb.setForeground(Color.red);
            lb.setFont(new java.awt.Font("Segoe UI", 1, 24));
            pnlRoomList.add(lb);
            pnlRoomList.setPreferredSize(new Dimension(819, 300));
            pnlRoomList.updateUI();
            pnlRoomList.validate();
            pnlRoomList.repaint();
        }

    }

    private void pnlType1MouseReleased(MouseEvent evt) {
        RoomComponent pnl = (RoomComponent) evt.getComponent();
        if (preSelectedRoom == null) {
            preSelectedRoom = pnl;
        } else {
            preSelectedRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
            preSelectedRoom = pnl;
        }
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
        if (evt.isPopupTrigger()) {
            if (pnl.getRoom().getStatus() == 4) {
                cleaning.setSelected(true);
            } else {
                cleaning.setSelected(false);
            }
            popupRoomType1.show(pnl, evt.getX(), evt.getY());
        }
    }

    private void pnlSettingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSettingMousePressed
        tableRoomType = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableRoomType.addColumn("Stt");
        tableRoomType.addColumn("Tên loại phòng");
        tableRoomType.addColumn("Giá (phòng/đêm)");
        tblRoomType.setModel(tableRoomType);
        fetchDataTableType();
        int countFloor = FloorDAOImpl.getAllFloors().size();
        String[] strSetting = getSettingFromFileConfig();
        String hotelName = strSetting[0];
        String hotelAddress = strSetting[1];
        txtHotelAddress.setText(hotelAddress);
        txtHotelName.setText(hotelName);
        txtFloor.setText(String.valueOf(countFloor));
        lbPreFloor.setText(String.valueOf(countFloor));
        setting.setLocationRelativeTo(this);
        mainOverLay.setVisible(true);
        settingOverLay.setVisible(false);
        setting.setVisible(true);
    }//GEN-LAST:event_pnlSettingMousePressed

    private void txtFloorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFloorKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtFloor.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtFloor.setEditable(true);
        }
    }//GEN-LAST:event_txtFloorKeyPressed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        String s = txtFloor.getText();
        if (!s.equals("")) {
            int n = Integer.parseInt(s);
            if (n == 1 || n == 0) {
                Toolkit.getDefaultToolkit().beep();
            } else {
                n--;
                txtFloor.setText(String.valueOf(n));
            }
        }
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        String s = txtFloor.getText();
        if (!s.equals("")) {
            int n = Integer.parseInt(s);
            if (n < 100) {
                n++;
                txtFloor.setText(String.valueOf(n));
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }//GEN-LAST:event_btnPlusActionPerformed

    private void pnlHeaderSettingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderSettingMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderSettingMousePressed

    private void pnlHeaderSettingMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderSettingMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setting.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderSettingMouseDragged

    private void lbCloseSettingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseSettingMousePressed
        mainOverLay.setVisible(false);
        setting.setVisible(false);
        lbErrorBasicSetting.setText("");
    }//GEN-LAST:event_lbCloseSettingMousePressed

    private void btnAddTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTypeActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền thêm loại phòng.");
            dialogError.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                settingOverLay.setVisible(false);
            }
        } else {
            lbTitleAddType.setText("Thêm loại phòng");
            dialogAddType.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogAddType.setVisible(true);
        }
    }//GEN-LAST:event_btnAddTypeActionPerformed

    private void lbCloseAddTypeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseAddTypeMousePressed
        settingOverLay.setVisible(false);
        dialogAddType.setVisible(false);
        resetFormAddType();
    }//GEN-LAST:event_lbCloseAddTypeMousePressed

    private void pnlHeaderAddTypeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddTypeMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogAddType.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderAddTypeMouseDragged

    private void pnlHeaderAddTypeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddTypeMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderAddTypeMousePressed

    private void btnResetAddTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAddTypeActionPerformed
        resetFormAddType();
    }//GEN-LAST:event_btnResetAddTypeActionPerformed
    private void resetFormAddType() {
        txtTypeName.setText("");
        txtTypePrice.setText("");
    }

    private void handleSaveType() {
        String typeName = txtTypeName.getText();
        String price = txtTypePrice.getText();
        if (typeName.equals("")) {
            lbErrorAddType.setText("Vui lòng điền tên loại!");
        } else if (price.equals("")) {
            lbErrorAddType.setText("Vui lòng điền giá!");
        } else {
            String roomTypeId = lbTypeId.getText().trim();
            RoomType roomType = null;
            if (roomTypeId.equals("")) {
                roomType = new RoomType(1, typeName, Float.parseFloat(price));
            } else {
                roomType = new RoomType(Integer.parseInt(lbTypeId.getText()), typeName, Float.parseFloat(price));
            }
            if (lbTitleAddType.getText().equals("Thêm loại phòng")) {
                if (RoomTypeDAOImpl.insertRoomType(roomType)) {
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Thêm thành công");
                    lbSuccess.setText("Đã thêm thành công loại phòng mới.");
                    dialogSuccess.setLocationRelativeTo(setting);
                    dialogAddType.setVisible(false);
                    dialogSuccess.setVisible(true);
                    settingOverLay.setVisible(false);
                    resetFormAddType();
                    fetchDataTableType();
                    setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                } else {
                    lbErrorAddType.setText("Loại phòng đã tồn tại");
                }
            } else {
                if (RoomTypeDAOImpl.updateRoomType(roomType)) {
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Cập nhật thành công");
                    lbSuccess.setText("Đã cập nhật thành công loại phòng.");
                    dialogSuccess.setLocationRelativeTo(setting);
                    dialogAddType.setVisible(false);
                    dialogSuccess.setVisible(true);
                    settingOverLay.setVisible(false);
                    resetFormAddType();
                    fetchDataTableType();
                    setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                } else {
                    lbErrorAddType.setText("Loại phòng đã tồn tại");
                }
            }
        }
    }
    private void btnSaveTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveTypeActionPerformed
        handleSaveType();
    }//GEN-LAST:event_btnSaveTypeActionPerformed

    private void txtTypeNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeNameFocusGained
        lbErrorAddType.setText("");
    }//GEN-LAST:event_txtTypeNameFocusGained

    private void txtTypePriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypePriceFocusGained
        lbErrorAddType.setText("");
    }//GEN-LAST:event_txtTypePriceFocusGained

    private void txtTypePriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypePriceKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtTypePrice.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtTypePrice.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveType();
        }
    }//GEN-LAST:event_txtTypePriceKeyPressed

    private void tblRoomTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomTypeMouseReleased
        int row = tblRoomType.getSelectedRow();
        if (evt.isPopupTrigger() && row != -1) {
            popupTableType.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_tblRoomTypeMouseReleased

    private void btnSaveFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFloorActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền thay đổi cài đặt.");
            dialogError.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                settingOverLay.setVisible(false);
            }
        } else {
            int floor = Integer.parseInt(txtFloor.getText());
            int preFloor = Integer.parseInt(lbPreFloor.getText());
            String hotelName = txtHotelName.getText().trim();
            String hotelAddress = txtHotelAddress.getText().trim();
            if (floor != preFloor) {
                LinkedList<String> deletedFloor = new LinkedList<>();
                LinkedList<String> undeleteFloor = new LinkedList<>();
                if (floor < preFloor) {
                    for (int i = floor + 1; i <= preFloor; i++) {
                        if (FloorDAOImpl.deleteFloorByName("Tầng " + i)) {
                            deletedFloor.add("Tầng " + i);
                        } else {
                            undeleteFloor.add("Tầng " + i);
                        }
                    }
                } else if (floor > preFloor) {
                    for (int i = preFloor + 1; i <= floor; i++) {
                        Floor f = new Floor();
                        f.setName("Tầng " + i);
                        FloorDAOImpl.insertFloor(f);
                    }

                }
                if (undeleteFloor.size() == 0) {
                    lbPreFloor.setText(String.valueOf(floor));
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Lưu thành công");
                    lbSuccess.setText("Đã lưu thiết lập cài đặt mới.");
                    dialogSuccess.setLocationRelativeTo(setting);
                    settingOverLay.setVisible(true);
                    dialogSuccess.setVisible(true);
                    settingOverLay.setVisible(false);
                    setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                } else {
                    lbErrorTitle.setText("Lỗi");
                    lbErrorTitleDetail.setText("Thông báo lỗi");
                    StringBuilder sb = new StringBuilder("Không thể xóa");
                    for (String s : undeleteFloor) {
                        sb.append(" " + s);
                    }
                    lbPreFloor.setText(undeleteFloor.getLast().substring(5));
                    txtFloor.setText(undeleteFloor.getLast().substring(5));
                    lbError.setText("<html>" + sb.toString() + "</html>");
                    dialogError.setLocationRelativeTo(setting);
                    settingOverLay.setVisible(true);
                    dialogError.setVisible(true);
                    if (deletedFloor.size() > 0) {
                        lbSuccessTitle.setText("Thành công");
                        lbSuccessTitleDetail.setText("Xóa thành công");
                        StringBuilder sb2 = new StringBuilder("Đã xóa");
                        for (String s : deletedFloor) {
                            sb2.append(" " + s);
                        }
                        lbSuccess.setText("<html>" + sb2.toString() + "</html>");
                        dialogSuccess.setLocationRelativeTo(setting);
                        dialogSuccess.setVisible(true);
                        settingOverLay.setVisible(false);
                    } else {
                        settingOverLay.setVisible(false);
                    }
                    setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                }
            }
            if (hotelName.equals("")) {
                lbErrorBasicSetting.setText("Vui lòng điền tên khách sạn");
            } else if (hotelName.length() < 3) {
                lbErrorBasicSetting.setText("Tên khách sạn quá ngắn");
            } else {
                File f = new File("config\\config.properties");
                Properties p = new Properties();
                try {
                    FileInputStream fin = new FileInputStream(f);
                    p.load(fin);
                    FileOutputStream fout = new FileOutputStream(f);
                    p.setProperty("hotelName", hotelName);
                    p.store(fout, "Saved setting");
                    fin.close();
                    fout.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (hotelAddress.equals("")) {
                lbErrorBasicSetting.setText("Vui lòng điền địa chỉ khách sạn");
            } else if (hotelAddress.length() < 3) {
                lbErrorBasicSetting.setText("Địa chỉ quá ngắn");
            } else {
                File f = new File("config\\config.properties");
                Properties p = new Properties();
                try {
                    FileInputStream fin = new FileInputStream(f);
                    p.load(fin);
                    FileOutputStream fout = new FileOutputStream(f);
                    p.setProperty("hotelAddress", hotelAddress);
                    p.store(fout, "Saved setting");
                    fin.close();
                    fout.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSaveFloorActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền xóa loại phòng.");
            dialogError.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                settingOverLay.setVisible(false);
            }
        } else {
            lbWarningTitle.setText("Cảnh báo");
            lbWarningTitleDetail.setText("Cảnh báo xóa");
            lbWarning.setText("Xác nhận xóa loại phòng.");
            dialogWarning.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogWarning.setVisible(true);
            int result = Integer.parseInt(lbWarningResult.getText());
            if (result == 1) {
                int row = tblRoomType.getSelectedRow();
                String typeName = tblRoomType.getValueAt(row, 1) + "";
                if (RoomTypeDAOImpl.deleteRoomTypeByName(typeName)) {
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Xóa thành công");
                    lbSuccess.setText("Đã xóa loại phòng thành công.");
                    dialogSuccess.setLocationRelativeTo(setting);
                    dialogSuccess.setVisible(true);
                    settingOverLay.setVisible(false);
                    fetchDataTableType();
                    setCbbItem(cbbFilterFloor, cbbFilterRoomType, cbbFilterStatus, null, null, null, true);
                } else {
                    lbErrorTitle.setText("Lỗi");
                    lbErrorTitleDetail.setText("Thông báo lỗi");
                    lbError.setText("Không thể xóa loại phòng này.");
                    dialogError.setLocationRelativeTo(setting);
                    dialogError.setVisible(true);
                    settingOverLay.setVisible(false);
                }
            } else {
                settingOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_itemDeleteActionPerformed

    private void itemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền sửa loại phòng.");
            dialogError.setLocationRelativeTo(setting);
            settingOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                settingOverLay.setVisible(false);
            }
        } else {
            int row = tblRoomType.getSelectedRow();
            String typeName = tblRoomType.getValueAt(row, 1) + "";
            double price = Double.parseDouble(tblRoomType.getValueAt(row, 2) + "");
            DecimalFormat formatter = new DecimalFormat("#0");
            lbTitleAddType.setText("Chỉnh sửa loại phòng");
            txtTypePrice.setText(formatter.format(price));
            txtTypeName.setText(typeName);
            dialogAddType.setLocationRelativeTo(setting);
            Connection con = DBUtilities.openConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                pstmt = con.prepareStatement("SELECT id FROM roomTypes WHERE name = ?");
                pstmt.setString(1, typeName.toLowerCase());
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    lbTypeId.setText(id + "");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            settingOverLay.setVisible(true);
            dialogAddType.setVisible(true);
        }
    }//GEN-LAST:event_itemEditActionPerformed

    private void lbCloseDialogWarningMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogWarningMousePressed
        lbWarningResult.setText("0");
        dialogWarning.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogWarningMousePressed

    private void btnCloseDialogWarningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseDialogWarningActionPerformed
        lbWarningResult.setText("0");
        dialogWarning.setVisible(false);
    }//GEN-LAST:event_btnCloseDialogWarningActionPerformed

    private void btnWarningAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarningAcceptActionPerformed
        lbWarningResult.setText("1");
        dialogWarning.setVisible(false);
    }//GEN-LAST:event_btnWarningAcceptActionPerformed

    private void lbCloseDialogErrorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogErrorMousePressed
        dialogError.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogErrorMousePressed

    private void btnCloseDialogErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseDialogErrorActionPerformed
        dialogError.setVisible(false);
    }//GEN-LAST:event_btnCloseDialogErrorActionPerformed

    private void lbCloseDialogSuccessMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogSuccessMousePressed
        dialogSuccess.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogSuccessMousePressed

    private void btnCloseDialogSuccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseDialogSuccessActionPerformed
        dialogSuccess.setVisible(false);
    }//GEN-LAST:event_btnCloseDialogSuccessActionPerformed

    private void pnlWarningHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWarningHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogWarning.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlWarningHeaderMouseDragged

    private void pnlWarningHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWarningHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlWarningHeaderMousePressed

    private void pnlErrorHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlErrorHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlErrorHeaderMousePressed

    private void pnlErrorHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlErrorHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogError.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlErrorHeaderMouseDragged

    private void pnlSuccessHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSuccessHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlSuccessHeaderMousePressed

    private void pnlSuccessHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSuccessHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogSuccess.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlSuccessHeaderMouseDragged

    private void lbCloseAddRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseAddRoomMousePressed
        dialogAddRoom.setVisible(false);
        txtRoomName.setText("");
        lbErrorAddRoom.setText("");
        mainOverLay.setVisible(false);
    }//GEN-LAST:event_lbCloseAddRoomMousePressed

    private void pnlHeaderAddRoomMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddRoomMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogAddRoom.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderAddRoomMouseDragged

    private void pnlHeaderAddRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddRoomMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderAddRoomMousePressed

    private void txtRoomNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRoomNameFocusGained
        lbErrorAddRoom.setText("");
    }//GEN-LAST:event_txtRoomNameFocusGained
    private void handleSaveRoom() {
        String roomName = txtRoomName.getText().trim();
        RoomType type = (RoomType) cbbAddRoomType.getSelectedItem();
        Floor floor = (Floor) cbbAddRoomFloor.getSelectedItem();
        if (roomName.equals("")) {
            lbErrorAddRoom.setText("Vui lòng điền tên phòng.");
        } else {
            Room room = new Room();
            room.setName(roomName);
            room.setFloor(floor);
            room.setRoomType(type);
            if (lbTitleAddRoom.getText().trim().equalsIgnoreCase("Chỉnh sửa phòng")) {
                room.setId(preSelectedRoom.getRoom().getId());
                room.setStatus(preSelectedRoom.getRoom().getStatus());
                if (RoomDAOImpl.updateRoom(room)) {
                    dialogAddRoom.setVisible(false);
                    txtRoomName.setText("");
                    int index = roomList.indexOf(preSelectedRoom.getRoom());
                    roomList.remove(preSelectedRoom.getRoom());
                    roomList.add(index, room);
                    preSelectedRoom = null;
                    reloadRoomList = 1;
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Cập nhật thành công");
                    lbSuccess.setText("Đã cập nhật thành công phòng.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    filterRoom();
                } else {
                    lbErrorAddRoom.setText("Tên phòng đã tồn tại.");
                }
            } else {
                room.setStatus((short) 1);
                String id = UUID.randomUUID().toString();
                room.setId(id);
                if (RoomDAOImpl.insertRoom(room)) {
                    dialogAddRoom.setVisible(false);
                    txtRoomName.setText("");
                    roomList.add(room);
                    preSelectedRoom = null;
                    reloadRoomStatusChart = 1;
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Thêm thành công");
                    lbSuccess.setText("Đã thêm thành công phòng.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    filterRoom();
                } else {
                    lbErrorAddRoom.setText("Tên phòng đã tồn tại.");
                }
            }
        }
    }
    private void btnSaveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRoomActionPerformed
        handleSaveRoom();
    }//GEN-LAST:event_btnSaveRoomActionPerformed

    private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền thêm phòng.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            setCbbItem(cbbAddRoomFloor, cbbAddRoomType, null, null, null, null, false);
            dialogAddRoom.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            lbTitleAddRoom.setText("Thêm phòng");
            dialogAddRoom.setVisible(true);
        }
    }//GEN-LAST:event_btnAddRoomActionPerformed

    private void btnSearchRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRoomActionPerformed
        String keyword = txtSearchRoom.getText().trim();
        if (keyword.equals("")) {
            if (filterRoomList.size() > 0) {
                displayRoomList(filterRoomList);
            } else {
                displayRoomList(roomList);
            }
        } else {
            LinkedList<Room> searchList = new LinkedList<>();
            for (Room room : roomList) {
                if (room.getName().equalsIgnoreCase(keyword)) {
                    searchList.add(room);
                }
            }
            displayRoomList(searchList);
        }
    }//GEN-LAST:event_btnSearchRoomActionPerformed
    private void addFilterRoomList(int floorId, int roomTypeId, int status, LinkedList<Room> list) {
        filterRoomList = new LinkedList<>();
        if (floorId == 0 && roomTypeId == 0 && status == 0) {
            filterRoomList.addAll(list);
        } else if (floorId == 0 && roomTypeId != 0 && status != 0) {
            for (Room r : list) {
                if (r.getRoomType().getId() == roomTypeId && r.getStatus() == status) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId != 0 && roomTypeId == 0 && status != 0) {
            for (Room r : list) {
                if (r.getFloor().getId() == floorId && r.getStatus() == status) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId != 0 && roomTypeId != 0 && status == 0) {
            for (Room r : list) {
                if (r.getRoomType().getId() == roomTypeId && r.getFloor().getId() == floorId) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId == 0 && roomTypeId == 0 && status != 0) {
            for (Room r : list) {
                if (r.getStatus() == status) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId != 0 && roomTypeId == 0 && status == 0) {
            for (Room r : list) {
                if (r.getFloor().getId() == floorId) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId == 0 && roomTypeId != 0 && status == 0) {
            for (Room r : list) {
                if (r.getRoomType().getId() == roomTypeId) {
                    filterRoomList.add(r);
                }
            }
        } else if (floorId != 0 && roomTypeId != 0 && status != 0) {
            for (Room r : list) {
                if (r.getRoomType().getId() == roomTypeId && r.getFloor().getId() == floorId && r.getStatus() == status) {
                    filterRoomList.add(r);
                }
            }
        }
    }

    private void filterRoom() {
        Floor f = (Floor) cbbFilterFloor.getSelectedItem();
        int fid = f.getId();
        RoomType t = (RoomType) cbbFilterRoomType.getSelectedItem();
        int tid = t.getId();
        String status = (String) cbbFilterStatus.getSelectedItem();
        int stt = 0;
        if (status.equalsIgnoreCase("trống")) {
            stt = 1;
        } else if (status.equalsIgnoreCase("đang sử dụng")) {
            stt = 2;
        } else if (status.equalsIgnoreCase("đặt trước")) {
            stt = 3;
        } else if (status.equalsIgnoreCase("đang dọn dẹp")) {
            stt = 4;
        }
        addFilterRoomList(fid, tid, stt, roomList);
        displayRoomList(filterRoomList);
    }
    private void btnFilterRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterRoomActionPerformed
        filterRoom();
    }//GEN-LAST:event_btnFilterRoomActionPerformed

    private void txtHotelNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHotelNameFocusGained
        lbErrorBasicSetting.setText("");
    }//GEN-LAST:event_txtHotelNameFocusGained

    private void txtHotelAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHotelAddressFocusGained
        lbErrorBasicSetting.setText("");
    }//GEN-LAST:event_txtHotelAddressFocusGained

    private void deleteRoomType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomType1ActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền xóa phòng.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            lbWarningTitle.setText("Cảnh báo");
            lbWarningTitleDetail.setText("Cảnh báo xóa");
            lbWarning.setText("<html>Bạn có muốn xóa phòng này không?</html>");
            dialogWarning.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogWarning.setVisible(true);
            int result = Integer.parseInt(lbWarningResult.getText());
            if (result == 1) {
                if (RoomDAOImpl.deteleRoomById(preSelectedRoom.getRoom().getId())) {
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Xóa thành công");
                    lbSuccess.setText("Đã xóa thành công phòng.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    roomList.remove(preSelectedRoom.getRoom());
                    filterRoom();
                    preSelectedRoom = null;
                    reloadRoomStatusChart = 1;
                } else {
                    lbErrorTitle.setText("Lỗi");
                    lbErrorTitleDetail.setText("Thông báo lỗi");
                    lbError.setText("Không thể xóa phòng này!");
                    dialogError.setLocationRelativeTo(bg);
                    dialogError.setVisible(true);
                    mainOverLay.setVisible(false);
                }
            } else {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_deleteRoomType1ActionPerformed

    private void editRoomType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomType1ActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền sửa phòng.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            lbTitleAddRoom.setText("Chỉnh sửa phòng");
            txtRoomName.setText(preSelectedRoom.getRoom().getName());
            setCbbItem(cbbAddRoomFloor, cbbAddRoomType, null, preSelectedRoom.getRoom().getFloor(), preSelectedRoom.getRoom().getRoomType(), null, false);
            dialogAddRoom.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogAddRoom.setVisible(true);
        }
    }//GEN-LAST:event_editRoomType1ActionPerformed

    private void cleaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaningActionPerformed
        Room room = new Room();
        room.setId(preSelectedRoom.getRoom().getId());
        room.setRoomType(preSelectedRoom.getRoom().getRoomType());
        room.setFloor(preSelectedRoom.getRoom().getFloor());
        room.setName(preSelectedRoom.getRoom().getName());
        if (cleaning.isSelected()) {
            room.setStatus((short) 4);
            if (RoomDAOImpl.updateRoom(room)) {
                int index = roomList.indexOf(preSelectedRoom.getRoom());
                roomList.remove(preSelectedRoom.getRoom());
                roomList.add(index, room);
                reloadRoomList = 1;
                reloadRoomStatusChart = 1;
                filterRoom();
                preSelectedRoom = null;
            }
        } else {
            room.setStatus((short) 1);
            if (RoomDAOImpl.updateRoom(room)) {
                int index = roomList.indexOf(preSelectedRoom.getRoom());
                roomList.remove(preSelectedRoom.getRoom());
                roomList.add(index, room);
                reloadRoomList = 1;
                reloadRoomStatusChart = 1;
                filterRoom();
                preSelectedRoom = null;
            }
        }
    }//GEN-LAST:event_cleaningActionPerformed
    private void setLbSelected(JLabel lb) {
        lb.setForeground(new Color(122, 72, 221));
        lb.setFont(new java.awt.Font("Segoe UI", 1, 15));
        lb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(122, 72, 221)));
    }

    private void resetLbSelected(JLabel lb) {
        lb.setForeground(new Color(0, 0, 0));
        lb.setFont(new java.awt.Font("Segoe UI", 0, 15));
        lb.setBorder(null);
    }

    private void createBookingList(Integer month, Integer year, int status) {
        bookingListDisplay.clear();
        if (month != null && year != null) {
            for (Booking b : bookingList) {
                Date date = new Date(b.getCheckin().getTime());
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int lMonth = localDate.getMonthValue();
                int lYear = localDate.getYear();
                if (month == lMonth && year == lYear && status == b.getStatus()) {
                    bookingListDisplay.add(b);
                }
            }
        } else {
            for (Booking b : bookingList) {
                if (status == b.getStatus()) {
                    bookingListDisplay.add(b);
                }
            }
        }
    }

    private void displayBookingList(LinkedList<Booking> list, JTable tbl, boolean isHistory) {
        if (isHistory) {
            int i = 0;
            Object[][] o = new Object[list.size()][6];
            for (Booking b : list) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                o[i][0] = "  " + (i + 1) + "";
                o[i][1] = " " + b.getId();
                o[i][2] = "<html>Họ tên: " + b.getCustomer().getName() + "<br/>Số chứng minh: " + b.getCustomer().getIdentityCardNumber()
                        + "<br/>Số điện thoại: " + b.getCustomer().getPhone() + "</html>";
                o[i][3] = formatter.format(b.getCheckin());
                o[i][4] = formatter.format(b.getCheckout());
                o[i][5] = "<html>Mã nhân viên:  " + b.getUser().getId() + "<br/>Tên nhân viên: " + b.getUser().getFullName() + "</html>";
                i++;
            }
            tbl.setModel(new javax.swing.table.DefaultTableModel(
                    o,
                    new String[]{
                        "Stt", " Mã đặt phòng", "Thông tin khách hàng", "Nhận phòng", "Trả phòng", "Người tạo"
                    }
            ) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            if (tbl.getColumnModel().getColumnCount() > 0) {
                tbl.getColumnModel().getColumn(0).setResizable(false);
                tbl.getColumnModel().getColumn(0).setPreferredWidth(59);
                tbl.getColumnModel().getColumn(1).setResizable(false);
                tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
                tbl.getColumnModel().getColumn(2).setResizable(false);
                tbl.getColumnModel().getColumn(2).setPreferredWidth(200);
                tbl.getColumnModel().getColumn(3).setResizable(false);
                tbl.getColumnModel().getColumn(3).setPreferredWidth(120);
                tbl.getColumnModel().getColumn(4).setResizable(false);
                tbl.getColumnModel().getColumn(4).setPreferredWidth(120);
                tbl.getColumnModel().getColumn(5).setResizable(false);
                tbl.getColumnModel().getColumn(5).setPreferredWidth(180);
            }
        } else {
            Object[][] o = new Object[list.size()][5];
            int i = 0;
            for (Booking b : list) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                o[i][0] = "  " + (i + 1) + "";
                o[i][1] = " " + b.getId();
                o[i][2] = "<html>Họ tên: " + b.getCustomer().getName() + "<br/>Số chứng minh: " + b.getCustomer().getIdentityCardNumber()
                        + "<br/>Số điện thoại: " + b.getCustomer().getPhone() + "</html>";
                o[i][3] = formatter.format(b.getCheckin());
                o[i][4] = "<html>Mã nhân viên:  " + b.getUser().getId() + "<br/>Tên nhân viên: " + b.getUser().getFullName() + "</html>";
                i++;
            }
            tbl.setModel(new javax.swing.table.DefaultTableModel(
                    o,
                    new String[]{
                        " Stt", "Mã đặt phòng", "Thông tin khách hàng", "Nhận phòng", "Người tạo"
                    }
            ) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            if (tbl.getColumnModel().getColumnCount() > 0) {
                tbl.getColumnModel().getColumn(0).setResizable(false);
                tbl.getColumnModel().getColumn(0).setPreferredWidth(79);
                tbl.getColumnModel().getColumn(1).setResizable(false);
                tbl.getColumnModel().getColumn(1).setPreferredWidth(120);
                tbl.getColumnModel().getColumn(2).setResizable(false);
                tbl.getColumnModel().getColumn(2).setPreferredWidth(220);
                tbl.getColumnModel().getColumn(3).setResizable(false);
                tbl.getColumnModel().getColumn(3).setPreferredWidth(160);
                tbl.getColumnModel().getColumn(4).setResizable(false);
                tbl.getColumnModel().getColumn(4).setPreferredWidth(200);
            }
        }
    }
    private void lbOpenCard23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenCard23MousePressed
        spnlBookingHistory.getViewport().setBackground(Color.WHITE);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        cbbBookingHistoryMonth.setMonth(localDate.getMonthValue() - 1);
        cbbBookingHistoryYear.setYear(localDate.getYear());
        createBookingList(localDate.getMonthValue(), localDate.getYear(), 3);
        displayBookingList(bookingListDisplay, tblBookingHistory, true);
        setLbSelected(lbOpenCard23);
        resetLbSelected(lbOpenCard21);
        resetLbSelected(lbOpenCard22);
        cardLayout2.show(pnlCards2, "pnlCard23");
    }//GEN-LAST:event_lbOpenCard23MousePressed

    private void lbOpenCard21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenCard21MousePressed
        spnlPreBook.getViewport().setBackground(Color.WHITE);
        createBookingList(null, null, 1);
        displayBookingList(bookingListDisplay, tblPreBook, false);
        setLbSelected(lbOpenCard21);
        resetLbSelected(lbOpenCard22);
        resetLbSelected(lbOpenCard23);
        cardLayout2.show(pnlCards2, "pnlCard21");
    }//GEN-LAST:event_lbOpenCard21MousePressed

    private void lbOpenCard22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenCard22MousePressed
        spnlUsing.getViewport().setBackground(Color.WHITE);
        createBookingList(null, null, 2);
        displayBookingList(bookingListDisplay, tblUsing, false);
        setLbSelected(lbOpenCard22);
        resetLbSelected(lbOpenCard21);
        resetLbSelected(lbOpenCard23);
        cardLayout2.show(pnlCards2, "pnlCard22");
    }//GEN-LAST:event_lbOpenCard22MousePressed
    private void resetFormAddService() {
        txtServiceName.setText("");
        txtServicePrice.setText("");
    }
    private void lbCloseAddServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseAddServiceMousePressed
        mainOverLay.setVisible(false);
        dialogAddService.setVisible(false);
        resetFormAddService();
    }//GEN-LAST:event_lbCloseAddServiceMousePressed

    private void pnlHeaderAddServiceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddServiceMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogAddService.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderAddServiceMouseDragged

    private void pnlHeaderAddServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddServiceMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderAddServiceMousePressed

    private void txtServiceNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceNameFocusGained
        lbErrorAddService.setText("");
    }//GEN-LAST:event_txtServiceNameFocusGained
    private void handleSaveService() {
        String serviceName = txtServiceName.getText().trim().toLowerCase();
        String servicePrice = txtServicePrice.getText().trim();
        String serviceAmount = txtServiceAmount.getText().trim();
        if (serviceName.equals("")) {
            lbErrorAddService.setText("Vui lòng điền tên dịch vụ!");
        } else if (servicePrice.equals("")) {
            lbErrorAddService.setText("Vui lòng điền giá!");
        } else if (serviceAmount.equals("")) {
            lbErrorAddService.setText("Vui lòng điền số lượng!");
        } else {
            Service service = new Service();
            service.setName(serviceName);
            service.setPrice(Double.parseDouble(servicePrice));
            service.setAmount(Integer.parseInt(serviceAmount));
            if (lbTitleAddService.getText().trim().equalsIgnoreCase("Thêm dịch vụ")) {
                String id = UUID.randomUUID().toString();
                service.setId(id);
                if (ServiceDAOImpl.insertService(service)) {
                    dialogAddService.setVisible(false);
                    serviceList.add(service);
                    preSelectedService = null;
                    resetFormAddService();
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Thêm thành công");
                    lbSuccess.setText("Đã thêm thành công dịch vụ.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    filterService();
                } else {
                    lbErrorAddService.setText("Dịch vụ đã tồn tại!");
                }
            } else {
                service.setId(preSelectedService.getService().getId());
                if (ServiceDAOImpl.updateService(service)) {
                    dialogAddService.setVisible(false);
                    int index = serviceList.indexOf(preSelectedService.getService());
                    serviceList.remove(preSelectedService.getService());
                    serviceList.add(index, service);
                    preSelectedService = null;
                    resetFormAddService();
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Cập nhật thành công");
                    lbSuccess.setText("Đã cập nhật thành công dịch vụ.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    filterService();
                } else {
                    lbErrorAddService.setText("Dịch vụ đã tồn tại!");
                }
            }
        }
    }
    private void btnSaveServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveServiceActionPerformed
        handleSaveService();
    }//GEN-LAST:event_btnSaveServiceActionPerformed
    private void filterService() {
        String sort = (String) cbbServiceSort.getSelectedItem();
        String status = (String) cbbServiceStatus.getSelectedItem();
        filterServiceList.clear();
        if (sort.equalsIgnoreCase("giá tăng dần") && status.equalsIgnoreCase("Tất cả")) {
            filterServiceList.addAll(serviceList);
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
        } else if (sort.equalsIgnoreCase("giá tăng dần") && status.equalsIgnoreCase("vẫn còn")) {
            for (Service s : serviceList) {
                if (s.getAmount() > 0) {
                    filterServiceList.add(s);
                }
            }
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
        } else if (sort.equalsIgnoreCase("giá giảm dần") && status.equalsIgnoreCase("Tất cả")) {
            filterServiceList.addAll(serviceList);
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });

        } else if (sort.equalsIgnoreCase("giá tăng dần") && status.equalsIgnoreCase("đã hết")) {
            for (Service s : serviceList) {
                if (s.getAmount() == 0) {
                    filterServiceList.add(s);
                }
            }
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
        } else if (sort.equalsIgnoreCase("giá giảm dần") && status.equalsIgnoreCase("vẫn còn")) {
            for (Service s : serviceList) {
                if (s.getAmount() > 0) {
                    filterServiceList.add(s);
                }
            }
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
        } else if (sort.equalsIgnoreCase("giá giảm dần") && status.equalsIgnoreCase("đã hết")) {
            for (Service s : serviceList) {
                if (s.getAmount() == 0) {
                    filterServiceList.add(s);
                }
            }
            Collections.sort(filterServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
        }
        displayServiceList(filterServiceList);
    }
    private void txtServicePriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServicePriceFocusGained
        lbErrorAddService.setText("");
    }//GEN-LAST:event_txtServicePriceFocusGained

    private void txtServiceAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtServiceAmountFocusGained
        lbErrorAddService.setText("");
    }//GEN-LAST:event_txtServiceAmountFocusGained

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền thêm dịch vụ.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            mainOverLay.setVisible(true);
            dialogAddService.setLocationRelativeTo(this);
            lbTitleAddService.setText("Thêm dịch vụ");
            txtServiceAmount.setText("1");
            dialogAddService.setVisible(true);
        }
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void txtServicePriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicePriceKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtServicePrice.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtServicePrice.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveService();
        }
    }//GEN-LAST:event_txtServicePriceKeyPressed

    private void txtServiceAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServiceAmountKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtServiceAmount.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtServiceAmount.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveService();
        }
    }//GEN-LAST:event_txtServiceAmountKeyPressed

    private void btnFilterServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterServiceActionPerformed
        filterService();
    }//GEN-LAST:event_btnFilterServiceActionPerformed

    private void editServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editServiceActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền sửa dịch vụ.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            lbTitleAddService.setText("Cập nhật dịch vụ");
            txtServiceName.setText(preSelectedService.getService().getName());
            DecimalFormat formatter = new DecimalFormat("#0");
            txtServicePrice.setText(formatter.format(preSelectedService.getService().getPrice()));
            txtServiceAmount.setText(preSelectedService.getService().getAmount() + "");
            dialogAddService.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogAddService.setVisible(true);
        }
    }//GEN-LAST:event_editServiceActionPerformed

    private void deleteServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteServiceActionPerformed
        if (currentloggin.getRights().getId() == 2) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Bạn không có quyền xóa dịch vụ.");
            dialogError.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            lbWarningTitle.setText("Cảnh báo");
            lbWarningTitleDetail.setText("Cảnh báo xóa");
            lbWarning.setText("<html>Bạn có chắc chắn muốn xóa dịch vụ này không?</html>");
            dialogWarning.setLocationRelativeTo(this);
            mainOverLay.setVisible(true);
            dialogWarning.setVisible(true);
            int result = Integer.parseInt(lbWarningResult.getText());
            if (result == 1) {
                if (ServiceDAOImpl.deleteServiceById(preSelectedService.getService().getId())) {
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Xóa thành công");
                    lbSuccess.setText("Đã xóa dịch vụ thành công.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    serviceList.remove(preSelectedService.getService());
                    filterService();
                    preSelectedService = null;
                } else {
                    lbErrorTitle.setText("Lỗi");
                    lbErrorTitleDetail.setText("Thông báo lỗi");
                    lbError.setText("Không thể xóa dịch vụ này!");
                    dialogError.setLocationRelativeTo(bg);
                    dialogError.setVisible(true);
                    mainOverLay.setVisible(false);
                }
            } else {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_deleteServiceActionPerformed

    private void txtSearchServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchServiceKeyReleased
        String keyword = txtSearchService.getText().trim().toLowerCase();
        LinkedList<Service> searchList = new LinkedList<>();
        if (!keyword.equals("")) {
            searchList.clear();
            if (filterServiceList.size() > 0) {
                for (Service service : filterServiceList) {
                    if (service.getName().contains(keyword)) {
                        searchList.add(service);
                    }
                }
            } else {
                for (Service service : serviceList) {
                    if (service.getName().contains(keyword)) {
                        searchList.add(service);
                    }
                }
            }
            displayServiceList(searchList);
        } else {
            if (filterServiceList.size() > 0) {
                displayServiceList(filterServiceList);
            } else {
                displayServiceList(serviceList);
            }
        }
    }//GEN-LAST:event_txtSearchServiceKeyReleased

    private void lbCloseBookServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseBookServiceMousePressed
        dialogBookService.setVisible(false);
        mainOverLay.setVisible(false);
    }//GEN-LAST:event_lbCloseBookServiceMousePressed

    private void pnlHeaderBookServiceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderBookServiceMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogBookService.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderBookServiceMouseDragged

    private void pnlHeaderBookServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderBookServiceMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderBookServiceMousePressed
    private void displayReadyServiceList(LinkedList<Service> list) {
        pnlServiceList2.removeAll();
        int ListSize = list.size();
        pnlServiceList2.setLayout(new FlowLayout(FlowLayout.LEADING, 4, 4));
        if (ListSize > 0) {
            ServiceComponent[] pnl = new ServiceComponent[ListSize];
            if (ListSize % 5 == 0) {
                pnlServiceList2.setPreferredSize(new Dimension(510, ListSize * 124 / 5));
                pnlServiceList2.updateUI();
            } else {
                pnlServiceList2.setPreferredSize(new Dimension(510, (ListSize / 5 + 1) * 124));
                pnlServiceList2.updateUI();
            }
            for (int i = 0; i < ListSize; i++) {
                Service service = list.get(i);
                pnl[i] = new ServiceComponent(service);
                pnl[i].getLbRemove().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        lbRemoveServiceComponentMousePressed(evt);
                    }
                });
                if (bookingServiceList.contains(service)) {
                    pnl[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
                    pnl[i].getLbRemove().setVisible(true);
                } else {
                    pnl[i].getLbRemove().setVisible(false);
                }
                pnl[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        pnlService2MousePressed(evt);
                    }
                });
                pnlServiceList2.add(pnl[i]);
                pnlServiceList2.validate();
                pnlServiceList2.repaint();
            }
        }
    }

    private void pnlService2MousePressed(MouseEvent evt) {
        ServiceComponent pnl = (ServiceComponent) evt.getComponent();
        bookingServiceList.add(pnl.getService());
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
        pnl.getLbRemove().setVisible(true);
        if (bookingServiceList.size() > 0) {
            btnResetBookingServiceList.setEnabled(true);
        }
    }

    private void lbRemoveServiceComponentMousePressed(MouseEvent evt) {
        ServiceComponent pnl = (ServiceComponent) evt.getComponent().getParent().getParent().getParent();
        bookingServiceList.remove(pnl.getService());
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        pnl.getLbRemove().setVisible(false);
        if (bookingServiceList.size() == 0) {
            btnResetBookingServiceList.setEnabled(false);
        }
    }
    private void btnBookServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookServiceActionPerformed
        bookServiceOverlay.setVisible(false);
        dialogBookService.setLocationRelativeTo(this);
        spnlServiceList2.getVerticalScrollBar().setUnitIncrement(12);
        txtSearchService2.setText("");
        cbbServiceSort2.setSelectedIndex(0);
        readyServiceList.clear();
        for (Service service : serviceList) {
            if (service.getAmount() > 0) {
                readyServiceList.add(service);
            }
        }
        if (readyServiceList.size() > 0) {
            bookingServiceList.clear();
            Collections.sort(readyServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            displayReadyServiceList(readyServiceList);
            cardLayout3.show(pnlCards3, "pnlCard31");
            mainOverLay.setVisible(true);
            dialogBookService.setVisible(true);
        } else {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Không có dịch vụ nào để đặt.");
            dialogError.setLocationRelativeTo(setting);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnBookServiceActionPerformed

    private void txtSearchService2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchService2KeyReleased
        String keyword = txtSearchService2.getText().trim().toLowerCase();
        LinkedList<Service> searchList = new LinkedList<>();
        if (!keyword.equals("")) {
            searchList.clear();
            for (Service service : readyServiceList) {
                if (service.getName().contains(keyword)) {
                    searchList.add(service);
                }
            }
            displayReadyServiceList(searchList);
        } else {
            displayReadyServiceList(readyServiceList);
        }
    }//GEN-LAST:event_txtSearchService2KeyReleased

    private void cbbServiceSort2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbServiceSort2ActionPerformed
        String sort = ((String) cbbServiceSort2.getSelectedItem()).trim();
        if (sort.equalsIgnoreCase("giá tăng dần")) {
            Collections.sort(readyServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
        } else if (sort.equalsIgnoreCase("giá giảm dần")) {
            Collections.sort(readyServiceList, new Comparator<Service>() {
                @Override
                public int compare(Service o1, Service o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
        }
        displayReadyServiceList(readyServiceList);
    }//GEN-LAST:event_cbbServiceSort2ActionPerformed
    private void displayServiceDetailList(LinkedList<ServiceDetail> list) {
        pnlServiceDetailList.removeAll();
        int size = list.size();
        pnlServiceDetailList.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 6));
        BookingServiceComponent[] pnl = new BookingServiceComponent[size];
        pnlServiceDetailList.setPreferredSize(new Dimension(470, size * 106));
        pnlServiceDetailList.updateUI();
        for (int i = 0; i < size; i++) {
            pnl[i] = new BookingServiceComponent(list.get(i));
            pnl[i].getLbRemoveServiceDetail().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    lbRemoveServiceDetailMousePressed(evt);
                }
            });
            pnl[i].getLbPlusAmount().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    lbPlusAmountMousePressed(evt);
                }
            });
            pnl[i].getLbMinusAmount().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    lbMinusAmountMousePressed(evt);
                }
            });
            pnl[i].getTxtAmount().addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtAmountKeyReleased(evt);
                }
            });
            pnlServiceDetailList.add(pnl[i]);
            pnlServiceDetailList.validate();
            pnlServiceDetailList.repaint();
        }
    }

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {
        BookingServiceComponent pnl = (BookingServiceComponent) evt.getComponent().getParent().getParent().getParent().getParent();
        String s = pnl.getTxtAmount().getText().trim();
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            pnl.getTxtAmount().setEditable(false);
            Toolkit.getDefaultToolkit().beep();
            if (s.length() >= 2) {
                s = s.substring(0, s.length() - 2);
                pnl.getTxtAmount().setText(s);
            }
        } else {
            pnl.getTxtAmount().setEditable(true);
        }
        if (s.equals("")) {
            pnl.getTxtAmount().setText("1");
            pnl.getServiceDetail().setAmount(1);
        } else if (Integer.parseInt(s) > pnl.getServiceDetail().getService().getAmount()) {
            pnl.getTxtAmount().setText(pnl.getServiceDetail().getService().getAmount() + "");
            pnl.getServiceDetail().setAmount(pnl.getServiceDetail().getService().getAmount());
        } else {
            pnl.getServiceDetail().setAmount(Integer.parseInt(s));
        }
    }

    private void lbMinusAmountMousePressed(MouseEvent evt) {
        BookingServiceComponent pnl = (BookingServiceComponent) evt.getComponent().getParent().getParent().getParent();
        String s = pnl.getTxtAmount().getText().trim();
        if (Integer.parseInt(s) > 1) {
            pnl.getTxtAmount().setText((Integer.parseInt(s) - 1) + "");
            pnl.getServiceDetail().setAmount(Integer.parseInt(s) - 1);
        }
    }

    private void lbPlusAmountMousePressed(MouseEvent evt) {
        BookingServiceComponent pnl = (BookingServiceComponent) evt.getComponent().getParent().getParent().getParent();
        String s = pnl.getTxtAmount().getText().trim();
        if (Integer.parseInt(s) < pnl.getServiceDetail().getService().getAmount()) {
            pnl.getTxtAmount().setText((Integer.parseInt(s) + 1) + "");
            pnl.getServiceDetail().setAmount(Integer.parseInt(s) + 1);
        }
    }

    private void lbRemoveServiceDetailMousePressed(MouseEvent evt) {
        BookingServiceComponent pnl = (BookingServiceComponent) evt.getComponent().getParent().getParent().getParent();
        bookingServiceList.remove(pnl.getServiceDetail().getService());
        serviceDetailList.remove(pnl.getServiceDetail());
        displayServiceDetailList(serviceDetailList);
        displayReadyServiceList(readyServiceList);
        if (bookingServiceList.size() == 0) {
            btnResetBookingServiceList.setEnabled(false);
            cardLayout3.show(pnlCards3, "pnlCard31");
        }
    }
    private void btnOpenPnlCard32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenPnlCard32ActionPerformed
        if (bookingServiceList.size() == 0) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Vui lòng chọn dịch vụ muốn đặt.");
            dialogError.setLocationRelativeTo(dialogBookService);
            bookServiceOverlay.setVisible(true);
            dialogError.setVisible(true);
            bookServiceOverlay.setVisible(false);
        } else {
            serviceDetailList.clear();
            int i = 0;
            for (Service s : bookingServiceList) {
                ServiceDetail serviceDetail = new ServiceDetail();
                serviceDetail.setId(i + 1);
                serviceDetail.setAmount(1);
                serviceDetail.setService(s);
                serviceDetailList.add(serviceDetail);
                i++;
            }
            spnlServiceDetailList.getVerticalScrollBar().setUnitIncrement(12);
            displayServiceDetailList(serviceDetailList);
            cardLayout3.show(pnlCards3, "pnlCard32");
            roomList4 = new LinkedList<>();
            for (Room r : roomList) {
                if (r.getStatus() == (short) 2) {
                    roomList4.add(r);
                }
            }
        }
    }//GEN-LAST:event_btnOpenPnlCard32ActionPerformed

    private void btnResetBookingServiceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBookingServiceListActionPerformed
        bookingServiceList.clear();
        displayReadyServiceList(readyServiceList);
    }//GEN-LAST:event_btnResetBookingServiceListActionPerformed
    private void displayRoomList4(LinkedList<Room> list) {
        spnlRoomList4.getVerticalScrollBar().setUnitIncrement(12);
        pnlRoomList4.removeAll();
        int listSize = list.size();
        pnlRoomList4.setLayout(new FlowLayout(FlowLayout.LEADING, 9, 9));
        if (listSize > 0) {
            RoomComponent[] pnl = new RoomComponent[listSize];
            if (listSize % 3 == 0) {
                pnlRoomList4.setPreferredSize(new Dimension(510, (listSize * 189 / 3)));
                pnlRoomList4.updateUI();
            } else {
                pnlRoomList4.setPreferredSize(new Dimension(510, ((listSize / 3 + 1) * 189)));
                pnlRoomList4.updateUI();
            }
            int i = 0;
            for (Room room : list) {
                pnl[i] = new RoomComponent(room);
                pnl[i].getLbRemove().setVisible(false);
                pnl[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        pnlUsingRoomMousePressed(evt);
                    }
                });
                pnlRoomList4.add(pnl[i]);
                pnlRoomList4.validate();
                pnlRoomList4.repaint();
                i++;
            }
        } else {

        }
    }

    private void pnlUsingRoomMousePressed(MouseEvent evt) {
        RoomComponent pnl = (RoomComponent) evt.getComponent();
        if (preSelectedRoom == null) {
            preSelectedRoom = pnl;
        } else {
            preSelectedRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
            preSelectedRoom = pnl;
        }
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
    }
    private void btnBookingServiceNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingServiceNext1ActionPerformed
        preSelectedRoom = null;
        cardLayout3.show(pnlCards3, "pnlCard33");
        displayRoomList4(roomList4);
    }//GEN-LAST:event_btnBookingServiceNext1ActionPerformed

    private void btnOpenPnlCard31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenPnlCard31ActionPerformed
        cardLayout3.show(pnlCards3, "pnlCard31");
    }//GEN-LAST:event_btnOpenPnlCard31ActionPerformed
    private void resetFormAddCustomer() {
        lbCustomerId.setText("");
        lbErrorAddCustomer.setText("");
        txtCustomerEmail.setText("");
        txtCustomerIdentityCard.setText("");
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        rdMale.setSelected(true);
        dcCustomerBirthday.setDate(new Date(631150000000L));
    }
    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        resetFormAddCustomer();
        mainOverLay.setVisible(true);
        dialogAddCustomer.setLocationRelativeTo(this);
        lbTitleAddCustomer.setText("Thêm khách hàng");
        dialogAddCustomer.setVisible(true);
        if (!dialogAddCustomer.isVisible()) {
            mainOverLay.setVisible(false);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void txtSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCustomerKeyReleased
        String keyword = txtSearchCustomer.getText().trim().toLowerCase();
        LinkedList<Customer> searchList = new LinkedList<>();
        if (!keyword.equals("")) {
            searchList.clear();
            for (Customer c : customerList) {
                if (c.getName().toLowerCase().contains(keyword) || c.getIdentityCardNumber().contains(keyword)) {
                    searchList.add(c);
                }
            }
            displayCustomerTable(searchList);
        } else {
            displayCustomerTable(customerList);
        }
    }//GEN-LAST:event_txtSearchCustomerKeyReleased

    private void lbCloseAddCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseAddCustomerMousePressed
        dialogAddCustomer.setVisible(false);
    }//GEN-LAST:event_lbCloseAddCustomerMousePressed

    private void pnlHeaderAddCustomerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddCustomerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogAddCustomer.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderAddCustomerMouseDragged

    private void pnlHeaderAddCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderAddCustomerMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderAddCustomerMousePressed

    private void txtCustomerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerNameFocusGained
        lbErrorAddCustomer.setText("");
    }//GEN-LAST:event_txtCustomerNameFocusGained

    private void txtCustomerIdentityCardFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerIdentityCardFocusGained
        lbErrorAddCustomer.setText("");
    }//GEN-LAST:event_txtCustomerIdentityCardFocusGained

    private void txtCustomerPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerPhoneFocusGained
        lbErrorAddCustomer.setText("");
    }//GEN-LAST:event_txtCustomerPhoneFocusGained

    private void txtCustomerEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerEmailFocusGained
        lbErrorAddCustomer.setText("");
    }//GEN-LAST:event_txtCustomerEmailFocusGained
    private void handleSaveCustomer() {
        String name = txtCustomerName.getText().trim();
        String identityCard = txtCustomerIdentityCard.getText().trim();
        short gender = 0;
        if (rdFemale.isSelected()) {
            gender = 1;
        }
        Date birthday = dcCustomerBirthday.getDate();
        String phone = txtCustomerPhone.getText();
        String email = txtCustomerEmail.getText();
        if (name.equals("")) {
            lbErrorAddCustomer.setText("Vui lòng nhập tên khách hàng!");
        } else if (identityCard.equals("")) {
            lbErrorAddCustomer.setText("Vui lòng điền số chứng minh nhân dân!");
        } else if (identityCard.length() != 9 && identityCard.length() != 12) {
            lbErrorAddCustomer.setText("Số chứng minh nhân dân không đúng!");
        } else if (birthday == null) {
            lbErrorAddCustomer.setText("Vui lòng chọn ngày sinh!");
        } else if (phone.equals("")) {
            lbErrorAddCustomer.setText("Vui lòng điền số điện thoại!");
        } else if (!email.equals("")) {
            String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            if (!email.matches(regexEmail)) {
                lbErrorAddCustomer.setText("Không đúng định dạng email!");
            }
        }
        if (lbErrorAddCustomer.getText().trim().equals("")) {
            Customer c = new Customer();
            c.setIdentityCardNumber(identityCard);
            c.setName(name);
            c.setBirthday(birthday);
            c.setPhone(phone);
            if (email.equals("")) {
                c.setEmail(null);
            } else {
                c.setEmail(email);
            }
            c.setGender(gender);
            if (lbTitleAddCustomer.getText().trim().equalsIgnoreCase("Thêm khách hàng")) {
                String id = UUID.randomUUID().toString();
                c.setId(id);
                if (CustomerDAOImpl.insertCustomer(c)) {
                    customerList.add(c);
                    dialogAddCustomer.setVisible(false);
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Thêm thành công");
                    lbSuccess.setText("Đã thêm thành công khách hàng.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    displayCustomerTable(customerList);
                } else {
                    lbErrorAddCustomer.setText("Khách hàng đã tồn tại!");
                }
            } else {
                String id = lbCustomerId.getText();
                c.setId(id);
                if (CustomerDAOImpl.updateCustomer(c)) {
                    int index = customerList.indexOf(c);
                    customerList.remove(c);
                    customerList.add(index, c);
                    dialogAddCustomer.setVisible(false);
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Cập nhật thành công");
                    lbSuccess.setText("Đã cập nhật thành công khách hàng.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    displayCustomerTable(customerList);
                } else {
                    lbErrorAddCustomer.setText("Khách hàng đã tồn tại!");
                }
            }
        }
    }
    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        handleSaveCustomer();
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void txtCustomerPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerPhoneKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtCustomerPhone.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtCustomerPhone.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveCustomer();
        }
    }//GEN-LAST:event_txtCustomerPhoneKeyPressed

    private void txtCustomerIdentityCardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerIdentityCardKeyPressed
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            txtCustomerIdentityCard.setEditable(false);
            Toolkit.getDefaultToolkit().beep();
        } else {
            txtCustomerIdentityCard.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveCustomer();
        }
    }//GEN-LAST:event_txtCustomerIdentityCardKeyPressed

    private void tblCustomerListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerListMouseReleased
        int row = tblCustomerList.getSelectedRow();
        if (evt.isPopupTrigger() && row != -1) {
            popupCustomer.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblCustomerListMouseReleased

    private void editCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerActionPerformed
        int row = tblCustomerList.getSelectedRow();
        String identityCard = tblCustomerList.getValueAt(row, 1) + "";
        Customer c = CustomerDAOImpl.getCustomerByIdentityCard(identityCard);
        lbTitleAddCustomer.setText("Chỉnh sửa khách hàng");
        txtCustomerEmail.setText(c.getEmail());
        txtCustomerIdentityCard.setText(c.getIdentityCardNumber());
        txtCustomerName.setText(c.getName());
        txtCustomerPhone.setText(c.getPhone());
        dcCustomerBirthday.setDate(c.getBirthday());
        lbCustomerId.setText(c.getId());
        if (c.getGender() == 0) {
            rdMale.setSelected(true);
        } else {
            rdFemale.setSelected(true);
        }
        dialogAddCustomer.setLocationRelativeTo(this);
        mainOverLay.setVisible(true);
        dialogAddCustomer.setVisible(true);
        if (!dialogAddCustomer.isVisible()) {
            mainOverLay.setVisible(false);
        }
    }//GEN-LAST:event_editCustomerActionPerformed

    private void txtSearchRoom2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchRoom2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchRoom2KeyReleased

    private void btnOpenPnlCard42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenPnlCard42ActionPerformed
        if (bookingRoomList.size() == 0) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Vui lòng chọn phòng muốn đặt!");
            dialogError.setLocationRelativeTo(dialogBookRoom);
            dialogError.setVisible(true);
        } else {
            lbErrorCustomerInfo.setText("");
            txtCustomerIdentityCard2.setText("");
            txtCustomerName2.setText("");
            rdMale2.setSelected(true);
            dcCustomerBirthday2.setDate(new Date(631150000000L));
            txtCustomerPhone2.setText("");
            txtCustomerEmail2.setText("");
            if (customerList == null) {
                customerList = CustomerDAOImpl.getAllCustomers();
            }
            bookingDetailList.clear();
            currentBooking = new Booking();
            long id = new Date().getTime() / 1000;
            currentBooking.setId(id + "");
            currentBooking.setUser(currentloggin);
            int i = 0;
            for (Room r : bookingRoomList) {
                BookingDetail bd = new BookingDetail();
                bd.setBooking(currentBooking);
                bd.setRoom(r);
                bd.setServicePrice(0);
                bookingDetailList.add(bd);
                i++;
            }
            cardLayout4.show(pnlCards4, "pnlCard42");
        }
    }//GEN-LAST:event_btnOpenPnlCard42ActionPerformed

    private void btnResetBookingRoomListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBookingRoomListActionPerformed
        bookingRoomList.clear();
        displayReadyRoomList(readyRoomList);
    }//GEN-LAST:event_btnResetBookingRoomListActionPerformed

    private void lbCloseBookRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseBookRoomMousePressed
        dialogBookRoom.setVisible(false);
    }//GEN-LAST:event_lbCloseBookRoomMousePressed

    private void pnlHeaderBookRoomMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderBookRoomMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogBookRoom.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlHeaderBookRoomMouseDragged

    private void pnlHeaderBookRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderBookRoomMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlHeaderBookRoomMousePressed

    private void btnFilterRoom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterRoom2ActionPerformed
        Floor f = (Floor) cbbRoomFloor.getSelectedItem();
        int fid = f.getId();
        RoomType t = (RoomType) cbbRoomType.getSelectedItem();
        int tid = t.getId();
        addFilterRoomList(fid, tid, 1, readyRoomList);
        displayReadyRoomList(filterRoomList);
    }//GEN-LAST:event_btnFilterRoom2ActionPerformed
    private void displayReadyRoomList(LinkedList<Room> list) {
        pnlRoomList2.removeAll();
        int listSize = list.size();
        pnlRoomList2.setLayout(new FlowLayout(FlowLayout.LEADING, 8, 8));
        if (listSize > 0) {
            RoomComponent[] pnl = new RoomComponent[listSize];
            if (listSize % 3 == 0) {
                pnlRoomList2.setPreferredSize(new Dimension(504, (listSize * 188 / 3)));
                pnlRoomList2.updateUI();
            } else {
                pnlRoomList2.setPreferredSize(new Dimension(504, ((listSize / 3 + 1) * 188)));
                pnlRoomList2.updateUI();
            }
            int i = 0;
            for (Room room : list) {
                pnl[i] = new RoomComponent(room);
                pnl[i].getLbRemove().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        lbRemoveRoomMousePressed(evt);
                    }
                });
                if (bookingRoomList.contains(room)) {
                    pnl[i].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
                    pnl[i].getLbRemove().setVisible(true);
                } else {
                    pnl[i].getLbRemove().setVisible(false);
                }
                pnl[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        pnlRoom2MousePressed(evt);
                    }
                });
                pnlRoomList2.add(pnl[i]);
                pnlRoomList2.validate();
                pnlRoomList2.repaint();
                i++;
            }
        } else {
            JLabel lb = new JLabel(" Không có phòng nào!");
            lb.setForeground(Color.red);
            lb.setFont(new java.awt.Font("Segoe UI", 1, 20));
            pnlRoomList2.add(lb);
            pnlRoomList2.setPreferredSize(new Dimension(504, 200));
            pnlRoomList2.updateUI();
            pnlRoomList2.validate();
            pnlRoomList2.repaint();
        }
    }

    private void lbRemoveRoomMousePressed(MouseEvent evt) {
        RoomComponent pnl = (RoomComponent) evt.getComponent().getParent().getParent().getParent();
        bookingRoomList.remove(pnl.getRoom());
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        pnl.getLbRemove().setVisible(false);
        if (bookingRoomList.size() == 0) {
            btnResetBookingRoomList.setEnabled(false);
        }
    }

    private void pnlRoom2MousePressed(MouseEvent evt) {
        RoomComponent pnl = (RoomComponent) evt.getComponent();
        bookingRoomList.add(pnl.getRoom());
        pnl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(48, 250, 2), 2));
        pnl.getLbRemove().setVisible(true);
        if (bookingRoomList.size() > 0) {
            btnResetBookingRoomList.setEnabled(true);
        }
    }
    private void btnBookRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookRoomActionPerformed
        if (readyRoomList.size() > 0) {
            bookingRoomList.clear();
            dialogBookRoom.setLocationRelativeTo(bg);
            pnlRoomList2.removeAll();
            pnlRoomList2.setPreferredSize(new Dimension(504, 250));
            spnlRoomList2.getVerticalScrollBar().setUnitIncrement(16);
            setCbbItem(cbbRoomFloor, cbbRoomType, null, null, null, null, true);
            cardLayout4.show(pnlCards4, "pnlCard41");
            displayReadyRoomList(readyRoomList);
            mainOverLay.setVisible(true);
            dialogBookRoom.setVisible(true);
            if (!dialogBookRoom.isVisible()) {
                mainOverLay.setVisible(false);
            }
        } else {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("Không còn phòng nào trống!");
            dialogError.setLocationRelativeTo(bg);
            mainOverLay.setVisible(true);
            dialogError.setVisible(true);
            if (!dialogError.isVisible()) {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnBookRoomActionPerformed

    private void txtSearchBooking3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooking3KeyReleased
        String keyword = txtSearchBooking3.getText().trim().toLowerCase();
        LinkedList<Booking> list = new LinkedList<>();
        if (keyword.equals("")) {
            displayBookingList(bookingListDisplay, tblBookingHistory, true);
        } else {
            for (Booking b : bookingListDisplay) {
                if (b.getCustomer().getName().toLowerCase().contains(keyword) || b.getCustomer().getIdentityCardNumber().contains(keyword)) {
                    list.add(b);
                }
            }
            displayBookingList(list, tblBookingHistory, true);
        }
    }//GEN-LAST:event_txtSearchBooking3KeyReleased

    private void cbbBookingHistoryMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbbBookingHistoryMonthPropertyChange
        int mouth = cbbBookingHistoryMonth.getMonth();
        int year = cbbBookingHistoryYear.getYear();
        createBookingList(mouth + 1, year, 3);
        displayBookingList(bookingListDisplay, tblBookingHistory, true);
    }//GEN-LAST:event_cbbBookingHistoryMonthPropertyChange

    private void cbbBookingHistoryYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbbBookingHistoryYearPropertyChange
        int mouth = cbbBookingHistoryMonth.getMonth();
        int year = cbbBookingHistoryYear.getYear();
        createBookingList(mouth + 1, year, 3);
        displayBookingList(bookingListDisplay, tblBookingHistory, true);
    }//GEN-LAST:event_cbbBookingHistoryYearPropertyChange

    private void txtSearchBooking3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking3FocusGained
        if (txtSearchBooking3.getForeground().equals(new Color(100, 100, 100))) {
            txtSearchBooking3.setForeground(Color.BLACK);
            txtSearchBooking3.setText("");
        }
    }//GEN-LAST:event_txtSearchBooking3FocusGained

    private void txtSearchBooking3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking3FocusLost
        String txt = txtSearchBooking3.getText().trim();
        if (txt.equals("")) {
            txtSearchBooking3.setForeground(new Color(100, 100, 100));
            txtSearchBooking3.setText("Số CMND hoặc tên khách hàng");
        }
    }//GEN-LAST:event_txtSearchBooking3FocusLost

    private void txtSearchBooking4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking4FocusGained
        if (txtSearchBooking4.getForeground().equals(new Color(100, 100, 100))) {
            txtSearchBooking4.setForeground(Color.BLACK);
            txtSearchBooking4.setText("");
        }
    }//GEN-LAST:event_txtSearchBooking4FocusGained

    private void txtSearchBooking4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking4FocusLost
        String txt = txtSearchBooking4.getText().trim();
        if (txt.equals("")) {
            txtSearchBooking4.setForeground(new Color(100, 100, 100));
            txtSearchBooking4.setText("Số CMND hoặc tên khách hàng");
        }
    }//GEN-LAST:event_txtSearchBooking4FocusLost

    private void txtSearchBooking4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooking4KeyReleased
        String keyword = txtSearchBooking4.getText().trim().toLowerCase();
        LinkedList<Booking> list = new LinkedList<>();
        if (keyword.equals("")) {
            displayBookingList(bookingListDisplay, tblUsing, false);
        } else {
            for (Booking b : bookingListDisplay) {
                if (b.getCustomer().getName().toLowerCase().contains(keyword) || b.getCustomer().getIdentityCardNumber().contains(keyword)) {
                    list.add(b);
                }
            }
            displayBookingList(list, tblUsing, false);
        }
    }//GEN-LAST:event_txtSearchBooking4KeyReleased

    private void txtSearchBooking5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking5FocusGained
        if (txtSearchBooking5.getForeground().equals(new Color(100, 100, 100))) {
            txtSearchBooking5.setForeground(Color.BLACK);
            txtSearchBooking5.setText("");
        }
    }//GEN-LAST:event_txtSearchBooking5FocusGained

    private void txtSearchBooking5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBooking5FocusLost
        String txt = txtSearchBooking5.getText().trim();
        if (txt.equals("")) {
            txtSearchBooking5.setForeground(new Color(100, 100, 100));
            txtSearchBooking5.setText("Số CMND hoặc tên khách hàng");
        }
    }//GEN-LAST:event_txtSearchBooking5FocusLost

    private void txtSearchBooking5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooking5KeyReleased
        String keyword = txtSearchBooking5.getText().trim().toLowerCase();
        LinkedList<Booking> list = new LinkedList<>();
        if (keyword.equals("")) {
            displayBookingList(bookingListDisplay, tblPreBook, false);
        } else {
            for (Booking b : bookingListDisplay) {
                if (b.getCustomer().getName().toLowerCase().contains(keyword) || b.getCustomer().getIdentityCardNumber().contains(keyword)) {
                    list.add(b);
                }
            }
            displayBookingList(list, tblPreBook, false);
        }
    }//GEN-LAST:event_txtSearchBooking5KeyReleased

    private void pnlBookingHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlBookingHeaderMousePressed

    private void pnlBookingHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogBooking.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlBookingHeaderMouseDragged

    private void lbCloseDialogBookingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogBookingMousePressed
        dialogBooking.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogBookingMousePressed
    private void displayTableBooking(LinkedList<BookingDetail> list, boolean isHistory) {
        int i = 0;
        long total = 0;
        Object[][] o = new Object[list.size()][7];
        NumberFormat numFormat = NumberFormat.getInstance(new Locale("en", "US"));
        for (BookingDetail bd : list) {
            o[i][0] = " " + (i + 1);
            o[i][1] = " " + bd.getRoom().getName();
            o[i][2] = " " + bd.getRoom().getRoomType().getName();
            o[i][3] = " " + numFormat.format(bd.getRoom().getRoomType().getPrice());
            long diff = 0L;
            if (isHistory) {
                diff = bd.getBooking().getCheckout().getTime() - bd.getBooking().getCheckin().getTime();
            } else {
                diff = new Date().getTime() - bd.getBooking().getCheckin().getTime();
            }
            long diffDays = (diff / (24 * 60 * 60 * 1000)) == 0L ? 1L : (diff / (24 * 60 * 60 * 1000));
            o[i][4] = " " + numFormat.format(diffDays);
            o[i][5] = " " + numFormat.format(bd.getServicePrice());
            long l = (long) ((diffDays * bd.getRoom().getRoomType().getPrice()) + bd.getServicePrice());
            o[i][6] = " " + numFormat.format(l);
            total += l;
            i++;
        }
        lbTotal.setText(numFormat.format(total) + " VNĐ");
        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
                o,
                new String[]{
                    "Stt", "Tên phòng", "Loại phòng", "Giá phòng", "<html><center>Số ngày<br> thuê</center></html>", "<html><center>Giá dịch vụ<br>đã dùng</center></html>", "Thành tiền"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        if (tblBooking.getColumnModel().getColumnCount() > 0) {
            tblBooking.getColumnModel().getColumn(0).setResizable(false);
            tblBooking.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblBooking.getColumnModel().getColumn(1).setResizable(false);
            tblBooking.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblBooking.getColumnModel().getColumn(2).setResizable(false);
            tblBooking.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblBooking.getColumnModel().getColumn(3).setResizable(false);
            tblBooking.getColumnModel().getColumn(3).setPreferredWidth(72);
            tblBooking.getColumnModel().getColumn(4).setResizable(false);
            tblBooking.getColumnModel().getColumn(4).setPreferredWidth(57);
            tblBooking.getColumnModel().getColumn(5).setResizable(false);
            tblBooking.getColumnModel().getColumn(5).setPreferredWidth(72);
            tblBooking.getColumnModel().getColumn(6).setResizable(false);
            tblBooking.getColumnModel().getColumn(6).setPreferredWidth(90);
        }
    }

    private void setupDialogBooking(Booking booking, boolean isHistory) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        if (isHistory) {
            lbPayDate.setText(formatter.format(booking.getCheckout()));
            displayTableBooking(currentBookingDetailList, true);
            btnBookingAction.setVisible(false);
        } else {
            lbPayDate.setText(formatter.format(new Date()));
            displayTableBooking(currentBookingDetailList, false);
            btnBookingAction.setVisible(true);
        }
        lbBookingUserId.setText(booking.getUser().getId());
        lbBookingUserName.setText(booking.getUser().getFullName());
        lbBookingUserRights.setText(booking.getUser().getRights().getName());
        lbBookingId.setText(booking.getId());
        lbCustomerName.setText(booking.getCustomer().getName());
        lbCustomerIdentityCard.setText(booking.getCustomer().getIdentityCardNumber());
        lbCustomerGender.setText(booking.getCustomer().getGender() == 0 ? "Nam" : "Nữ");
        lbCustomerBirthday.setText(formatter.format(booking.getCustomer().getBirthday()));
        lbCustomerPhone.setText(booking.getCustomer().getPhone());
        lbCustomerEmail.setText(booking.getCustomer().getEmail());
        spnlTblBooking.getViewport().setBackground(Color.WHITE);
        dialogBookingOverLay.setVisible(false);
    }
    private void txtCustomerIdentityCard2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerIdentityCard2FocusGained
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerIdentityCard2FocusGained

    private void txtCustomerName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerName2FocusGained
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerName2FocusGained

    private void txtCustomerName2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerName2KeyPressed
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerName2KeyPressed

    private void txtCustomerPhone2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerPhone2FocusGained
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerPhone2FocusGained

    private void txtCustomerPhone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerPhone2KeyPressed
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerPhone2KeyPressed

    private void txtCustomerEmail2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerEmail2FocusGained
        lbErrorCustomerInfo.setText("");
    }//GEN-LAST:event_txtCustomerEmail2FocusGained

    private void btnOpenPnlCard41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenPnlCard41ActionPerformed
        cardLayout4.show(pnlCards4, "pnlCard41");
    }//GEN-LAST:event_btnOpenPnlCard41ActionPerformed
    private void catchErrorCustomerInfo(String identityCard, String name, short gender, Date birthday, String phone, String email) {
        if (identityCard.equals("")) {
            lbErrorCustomerInfo.setText("Vui lòng điền số chứng minh nhân dân!");
        } else if (identityCard.length() != 9 && identityCard.length() != 12) {
            lbErrorCustomerInfo.setText("Số chứng minh nhân dân không đúng!");
        } else if (name.equals("")) {
            lbErrorCustomerInfo.setText("Vui lòng nhập tên khách hàng!");
        } else if (birthday == null) {
            lbErrorCustomerInfo.setText("Vui lòng chọn ngày sinh!");
        } else if (phone.equals("")) {
            lbErrorCustomerInfo.setText("Vui lòng điền số điện thoại!");
        } else if (!email.equals("")) {
            String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            if (!email.matches(regexEmail)) {
                lbErrorCustomerInfo.setText("Không đúng định dạng email!");
            }
        }
    }
    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        String name = txtCustomerName2.getText().trim();
        String identityCard = txtCustomerIdentityCard2.getText().trim();
        short gender = 0;
        if (rdFemale2.isSelected()) {
            gender = 1;
        }
        Date birthday = dcCustomerBirthday2.getDate();
        String phone = txtCustomerPhone2.getText();
        String email = txtCustomerEmail2.getText();
        catchErrorCustomerInfo(identityCard, name, gender, birthday, phone, email);
        if (lbErrorCustomerInfo.getText().trim().equals("")) {
            if (Integer.parseInt(lbNewCustomer.getText()) == 0) {
                Customer cus = CustomerDAOImpl.getCustomerById(lbCustomerId2.getText().trim());
                currentBooking.setCustomer(cus);
                currentBooking.setCheckin(new Date());
                currentBooking.setStatus((short) 2);
                if (BookingDAOImpl.insertBooking(currentBooking)) {
                    for (BookingDetail bd : bookingDetailList) {
                        BookingDetailDAOImpl.insertBookingDetail(bd);
                    }
                    int index = 0;
                    for (Room r : bookingRoomList) {
                        r.setStatus((short) 2);
                        RoomDAOImpl.updateRoom(r);
                        readyRoomList.remove(r);
                        index = roomList.indexOf(r);
                        roomList.remove(r);
                        roomList.add(index, r);
                    }
                    reloadRoomStatusChart = 1;
                    reloadRoomList = 1;
                    dialogBookRoom.setVisible(false);
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Xử lí thành công");
                    lbSuccess.setText("Đã Xử lí thành công.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    mainOverLay.setVisible(true);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    bookingList.add(currentBooking);
                    if (pnlCard22.isShowing()) {
                        createBookingList(null, null, 2);
                        displayBookingList(bookingListDisplay, tblUsing, false);
                    }
                }
            } else {
                Customer c = new Customer();
                String id = UUID.randomUUID().toString();
                c.setId(id);
                c.setIdentityCardNumber(identityCard);
                c.setName(name);
                c.setBirthday(birthday);
                c.setPhone(phone);
                if (email.equals("")) {
                    c.setEmail(null);
                } else {
                    c.setEmail(email);
                }
                c.setGender(gender);
                if (CustomerDAOImpl.insertCustomer(c)) {
                    customerList.add(c);
                    currentBooking.setCustomer(c);
                    currentBooking.setCheckin(new Date());
                    currentBooking.setStatus((short) 2);
                    if (BookingDAOImpl.insertBooking(currentBooking)) {
                        for (BookingDetail bd : bookingDetailList) {
                            BookingDetailDAOImpl.insertBookingDetail(bd);
                        }
                        int index = 0;
                        for (Room r : bookingRoomList) {
                            r.setStatus((short) 2);
                            RoomDAOImpl.updateRoom(r);
                            readyRoomList.remove(r);
                            index = roomList.indexOf(r);
                            roomList.remove(r);
                            roomList.add(index, r);
                        }
                        reloadRoomStatusChart = 1;
                        reloadRoomList = 1;
                        dialogBookRoom.setVisible(false);
                        lbSuccessTitle.setText("Thành công");
                        lbSuccessTitleDetail.setText("Xử lí thành công");
                        lbSuccess.setText("Đã Xử lí thành công.");
                        dialogSuccess.setLocationRelativeTo(bg);
                        mainOverLay.setVisible(true);
                        dialogSuccess.setVisible(true);
                        mainOverLay.setVisible(false);
                        bookingList.add(currentBooking);
                        if (pnlCard22.isShowing()) {
                            createBookingList(null, null, 2);
                            displayBookingList(bookingListDisplay, tblUsing, false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCheckinActionPerformed

    private void txtCustomerIdentityCard2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerIdentityCard2KeyReleased
        String s = txtCustomerIdentityCard2.getText().trim();
        if (s.length() != 9 && s.length() != 12) {
            txtCustomerName2.setEnabled(false);
            txtCustomerPhone2.setEnabled(false);
            txtCustomerEmail2.setEnabled(false);
            dcCustomerBirthday2.setEnabled(false);
            rdFemale2.setEnabled(false);
            rdMale2.setEnabled(false);
        } else {
            txtCustomerName2.setEnabled(true);
            txtCustomerPhone2.setEnabled(true);
            txtCustomerEmail2.setEnabled(true);
            dcCustomerBirthday2.setEnabled(true);
            rdFemale2.setEnabled(true);
            rdMale2.setEnabled(true);
        }
        for (Customer c : customerList) {
            if ((s.length() == 9 || s.length() == 12) && c.getIdentityCardNumber().equals(s)) {
                txtCustomerName2.setText(c.getName());
                if (c.getGender() == 0) {
                    rdMale2.setSelected(true);
                } else {
                    rdFemale2.setSelected(true);
                }
                dcCustomerBirthday2.setDate(c.getBirthday());
                txtCustomerPhone2.setText(c.getPhone());
                txtCustomerEmail2.setText(c.getEmail());
                lbCustomerId2.setText(c.getId());
                txtCustomerName2.setEnabled(false);
                txtCustomerPhone2.setEnabled(false);
                txtCustomerEmail2.setEnabled(false);
                dcCustomerBirthday2.setEnabled(false);
                rdFemale2.setEnabled(false);
                rdMale2.setEnabled(false);
                lbNewCustomer.setText("0");
                break;
            } else {
                lbNewCustomer.setText("1");
            }
        }
    }//GEN-LAST:event_txtCustomerIdentityCard2KeyReleased

    private void btnBookingRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingRoomActionPerformed
        String name = txtCustomerName2.getText().trim();
        String identityCard = txtCustomerIdentityCard2.getText().trim();
        short gender = 0;
        if (rdFemale2.isSelected()) {
            gender = 1;
        }
        Date birthday = dcCustomerBirthday2.getDate();
        String phone = txtCustomerPhone2.getText();
        String email = txtCustomerEmail2.getText();
        catchErrorCustomerInfo(identityCard, name, gender, birthday, phone, email);
        if (lbErrorCustomerInfo.getText().trim().equals("")) {
            if (Integer.parseInt(lbNewCustomer.getText()) == 0) {
                Customer cus = CustomerDAOImpl.getCustomerById(lbCustomerId2.getText().trim());
                currentBooking.setCustomer(cus);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, 1);
                currentBooking.setCheckin(cal.getTime());
                currentBooking.setStatus((short) 1);
                if (BookingDAOImpl.insertBooking(currentBooking)) {
                    for (BookingDetail bd : bookingDetailList) {
                        BookingDetailDAOImpl.insertBookingDetail(bd);
                    }
                    int index = 0;
                    for (Room r : bookingRoomList) {
                        r.setStatus((short) 3);
                        RoomDAOImpl.updateRoom(r);
                        readyRoomList.remove(r);
                        index = roomList.indexOf(r);
                        roomList.remove(r);
                        roomList.add(index, r);
                    }
                    reloadRoomStatusChart = 1;
                    reloadRoomList = 1;
                    dialogBookRoom.setVisible(false);
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Xử lí thành công");
                    lbSuccess.setText("Đã Xử lí thành công.");
                    dialogSuccess.setLocationRelativeTo(bg);
                    mainOverLay.setVisible(true);
                    dialogSuccess.setVisible(true);
                    mainOverLay.setVisible(false);
                    bookingList.add(currentBooking);
                    if (pnlCard21.isShowing()) {
                        createBookingList(null, null, 1);
                        displayBookingList(bookingListDisplay, tblPreBook, false);
                    }
                }
            } else {
                Customer c = new Customer();
                String id = UUID.randomUUID().toString();
                c.setId(id);
                c.setIdentityCardNumber(identityCard);
                c.setName(name);
                c.setBirthday(birthday);
                c.setPhone(phone);
                if (email.equals("")) {
                    c.setEmail(null);
                } else {
                    c.setEmail(email);
                }
                c.setGender(gender);
                if (CustomerDAOImpl.insertCustomer(c)) {
                    customerList.add(c);
                    currentBooking.setCustomer(c);
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 1);
                    currentBooking.setCheckin(cal.getTime());
                    currentBooking.setStatus((short) 1);
                    if (BookingDAOImpl.insertBooking(currentBooking)) {
                        for (BookingDetail bd : bookingDetailList) {
                            BookingDetailDAOImpl.insertBookingDetail(bd);
                        }
                        int index = 0;
                        for (Room r : bookingRoomList) {
                            r.setStatus((short) 3);
                            RoomDAOImpl.updateRoom(r);
                            readyRoomList.remove(r);
                            index = roomList.indexOf(r);
                            roomList.remove(r);
                            roomList.add(index, r);
                        }
                        reloadRoomStatusChart = 1;
                        reloadRoomList = 1;
                        dialogBookRoom.setVisible(false);
                        lbSuccessTitle.setText("Thành công");
                        lbSuccessTitleDetail.setText("Xử lí thành công");
                        lbSuccess.setText("Đã Xử lí thành công.");
                        dialogSuccess.setLocationRelativeTo(bg);
                        mainOverLay.setVisible(true);
                        dialogSuccess.setVisible(true);
                        mainOverLay.setVisible(false);
                        bookingList.add(currentBooking);
                        if (pnlCard21.isShowing()) {
                            createBookingList(null, null, 1);
                            displayBookingList(bookingListDisplay, tblPreBook, false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnBookingRoomActionPerformed
    private void displayTableBookingDetail(LinkedList<ServiceDetail> list) {
        int i = 0;
        Object[][] o = new Object[list.size()][5];
        NumberFormat numFormat = NumberFormat.getInstance(new Locale("en", "US"));
        for (ServiceDetail sd : list) {
            o[i][0] = " " + (i + 1);
            o[i][1] = " " + sd.getService().getName();
            o[i][2] = " " + numFormat.format(sd.getService().getPrice());
            o[i][3] = " " + sd.getAmount();
            double tp = sd.getService().getPrice() * sd.getAmount();
            o[i][4] = " " + numFormat.format(tp);
            i++;
        }
        tblBookingDetail.setModel(new javax.swing.table.DefaultTableModel(
                o,
                new String[]{
                    " Stt", "Tên dịch vụ", "Giá dịch vụ", "Số lượng", "Thành tiền"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        spnlTblBookingDetail.getViewport().setBackground(Color.WHITE);
        if (tblBookingDetail.getColumnModel().getColumnCount() > 0) {
            tblBookingDetail.getColumnModel().getColumn(0).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(0).setPreferredWidth(39);
            tblBookingDetail.getColumnModel().getColumn(1).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblBookingDetail.getColumnModel().getColumn(2).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblBookingDetail.getColumnModel().getColumn(3).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblBookingDetail.getColumnModel().getColumn(4).setResizable(false);
            tblBookingDetail.getColumnModel().getColumn(4).setPreferredWidth(100);
        }
    }
    private void tblBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblBooking.getSelectedRow();
            if (row >= 0) {
                NumberFormat numFormat = NumberFormat.getInstance(new Locale("en", "US"));
                String sindex = (tblBooking.getValueAt(row, 0) + "").trim();
                int index = Integer.parseInt(sindex) - 1;
                String countDate = (tblBooking.getValueAt(row, 4) + "").trim();
                String total = (tblBooking.getValueAt(row, 6) + "").trim();
                BookingDetail bd = currentBookingDetailList.get(index);
                lbBookingDetaillTitle.setText("Chi tiết đặt phòng " + bd.getRoom().getName());
                lbRoomName.setText(bd.getRoom().getName());
                lbRoomType.setText(bd.getRoom().getRoomType().getName());
                lbRoomPrice.setText(numFormat.format(bd.getRoom().getRoomType().getPrice()));
                lbCountDate.setText(countDate);
                Double roomCost = bd.getRoom().getRoomType().getPrice() * Integer.parseInt(countDate);
                lbRoomCost.setText(numFormat.format(roomCost));
                LinkedList<ServiceDetail> list = ServiceDetailDAOImpl.getServiceDetailByBookingDetailId(bd.getId());
                displayTableBookingDetail(list);
                lbTotal2.setText(total + " VNĐ");
                dialogBookingOverLay.setVisible(true);
                dialogBookingDetail.setLocationRelativeTo(dialogBooking);
                dialogBookingDetail.setVisible(true);
                dialogBookingOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_tblBookingMouseClicked

    private void pnlBookingDetailHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingDetailHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlBookingDetailHeaderMousePressed

    private void pnlBookingDetailHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingDetailHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogBookingDetail.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlBookingDetailHeaderMouseDragged

    private void lbCloseDialogBookingDetaillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogBookingDetaillMousePressed
        dialogBookingDetail.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogBookingDetaillMousePressed

    private void lbCloseDialogBookingInfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseDialogBookingInfoMousePressed
        dialogBookingInfo.setVisible(false);
    }//GEN-LAST:event_lbCloseDialogBookingInfoMousePressed

    private void pnlBookingInfoHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingInfoHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        dialogBookingInfo.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlBookingInfoHeaderMouseDragged

    private void pnlBookingInfoHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBookingInfoHeaderMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlBookingInfoHeaderMousePressed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        dialogBooking.setLocationRelativeTo(bg);
        dialogBooking.setVisible(true);
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCancelBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBookActionPerformed
        lbWarningTitle.setText("Cảnh báo");
        lbWarningTitleDetail.setText("Cảnh báo hủy");
        lbWarning.setText("Xác nhận hủy đặt phòng.");
        dialogWarning.setLocationRelativeTo(dialogBookingInfo);
        bookingInfoOverlay.setVisible(true);
        dialogWarning.setVisible(true);
        if (!dialogWarning.isVisible()) {
            bookingInfoOverlay.setVisible(false);
        }
        int result = Integer.parseInt(lbWarningResult.getText());
        if (result == 1) {
            for (BookingDetail bd : currentBookingDetailList) {
                BookingDetailDAOImpl.deleteBookingDetailById(bd.getId());
            }
            int index = 0;
            for (Room r : roomList3) {
                r.setStatus((short) 1);
                RoomDAOImpl.updateRoom(r);
                index = roomList.indexOf(r);
                roomList.remove(r);
                roomList.add(index, r);
            }
            reloadRoomStatusChart = 1;
            reloadRoomList = 1;
            roomList3 = null;
            lbSuccessTitle.setText("Thành công");
            lbSuccessTitleDetail.setText("Hủy thành công");
            lbSuccess.setText("Đã hủy đặt phòng.");
            dialogSuccess.setLocationRelativeTo(dialogBookingInfo);
            bookingInfoOverlay.setVisible(true);
            dialogSuccess.setVisible(true);
            bookingInfoOverlay.setVisible(false);
            BookingDAOImpl.deleteBookingById(currentBooking.getId());
            bookingList.remove(currentBooking);
            dialogBookingInfo.setVisible(false);
            createBookingList(null, null, 1);
            displayBookingList(bookingListDisplay, tblPreBook, false);
        }
    }//GEN-LAST:event_btnCancelBookActionPerformed
    private void displayRoomList3(LinkedList<Room> list, boolean preBook) {
        pnlRoomList3.removeAll();
        int listSize = list.size();
        pnlRoomList3.setLayout(new FlowLayout(FlowLayout.LEADING, 8, 8));
        if (listSize > 0) {
            RoomComponent[] pnl = new RoomComponent[listSize];
            if (listSize % 3 == 0) {
                pnlRoomList3.setPreferredSize(new Dimension(504, (listSize * 188 / 3)));
                pnlRoomList3.updateUI();
            } else {
                pnlRoomList3.setPreferredSize(new Dimension(504, ((listSize / 3 + 1) * 188)));
                pnlRoomList3.updateUI();
            }
            int i = 0;
            for (Room room : list) {
                pnl[i] = new RoomComponent(room);
                pnl[i].getLbRemove().setVisible(false);
                if (preBook) {
                    pnl[i].getLbRemove().setVisible(true);
                    pnl[i].getLbRemove().addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent evt) {
                            lbRemoveRoomMousePressed2(evt);
                        }
                    });
                }
                pnlRoomList3.add(pnl[i]);
                pnlRoomList3.validate();
                pnlRoomList3.repaint();
                i++;
            }
        } else {

        }
    }

    private void lbRemoveRoomMousePressed2(MouseEvent evt) {
        lbWarningTitle.setText("Cảnh báo");
        lbWarningTitleDetail.setText("Cảnh báo hủy");
        lbWarning.setText("Xác nhận hủy đặt phòng này.");
        dialogWarning.setLocationRelativeTo(dialogBookingInfo);
        bookingInfoOverlay.setVisible(true);
        dialogWarning.setVisible(true);
        if (!dialogWarning.isVisible()) {
            bookingInfoOverlay.setVisible(false);
        }
        int result = Integer.parseInt(lbWarningResult.getText());
        if (result == 1) {
            RoomComponent rc = (RoomComponent) evt.getComponent().getParent().getParent().getParent();
            Room r = rc.getRoom();
            int index = 0;
            for (BookingDetail bd : currentBookingDetailList) {
                if (bd.getRoom().equals(r)) {
                    BookingDetailDAOImpl.deleteBookingDetailById(bd.getId());
                    roomList3.remove(r);
                    r.setStatus((short) 1);
                    RoomDAOImpl.updateRoom(r);
                    index = roomList.indexOf(r);
                    roomList.remove(r);
                    roomList.add(index, r);
                }
            }
            reloadRoomList = 1;
            reloadRoomStatusChart = 1;
            lbSuccessTitle.setText("Thành công");
            lbSuccessTitleDetail.setText("Hủy thành công");
            lbSuccess.setText("Đã hủy đặt phòng.");
            dialogSuccess.setLocationRelativeTo(dialogBookingInfo);
            bookingInfoOverlay.setVisible(true);
            dialogSuccess.setVisible(true);
            bookingInfoOverlay.setVisible(false);
            if (roomList3.size() == 0) {
                BookingDAOImpl.deleteBookingById(currentBooking.getId());
                bookingList.remove(currentBooking);
                dialogBookingInfo.setVisible(false);
                createBookingList(null, null, 1);
                displayBookingList(bookingListDisplay, tblPreBook, false);
            } else {
                displayRoomList3(roomList3, true);
            }
        }
    }

    private void setupDialogBookingInfo(Booking booking, boolean isUsing) {
        bookingInfoOverlay.setVisible(false);
        lbUserId2.setText(booking.getUser().getId());
        lbUserName2.setText(booking.getUser().getFullName());
        lbUserRights2.setText(booking.getUser().getRights().getName());
        lbBookingId2.setText(booking.getId());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        lbCheckin2.setText(formatter.format(booking.getCheckin()));
        lbCustomerName2.setText(booking.getCustomer().getName());
        lbCustomerIdentityCard2.setText(booking.getCustomer().getIdentityCardNumber());
        lbCustomerGender2.setText(booking.getCustomer().getGender() == 0 ? "Nam" : "Nữ");
        lbCustomerPhone2.setText(booking.getCustomer().getPhone());
        spnlRoomList3.getViewport().setBackground(Color.WHITE);
        roomList3 = new LinkedList<>();
        roomList3.clear();
        for (BookingDetail bd : currentBookingDetailList) {
            roomList3.add(bd.getRoom());
        }
        if (isUsing) {
            displayRoomList3(roomList3, false);
            btnCancelBook.setVisible(false);
            btnGetRoom.setVisible(false);
            btnPay.setVisible(true);
        } else {
            displayRoomList3(roomList3, true);
            btnCancelBook.setVisible(true);
            btnGetRoom.setVisible(true);
            btnPay.setVisible(false);
        }
    }
    private void tblUsingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsingMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblUsing.getSelectedRow();
            String id = (tblUsing.getValueAt(row, 1) + "").trim();
            currentBooking = BookingDAOImpl.getBookingById(id);
            currentBookingDetailList = BookingDetailDAOImpl.getBookingDetailsByBookingId(id);
            setupDialogBookingInfo(currentBooking, true);
            setupDialogBooking(currentBooking, false);
            dialogBookingInfo.setLocationRelativeTo(bg);
            mainOverLay.setVisible(true);
            dialogBookingInfo.setVisible(true);
            if (!dialogBookingInfo.isVisible()) {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_tblUsingMouseClicked

    private void btnBookingActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionActionPerformed
        currentBooking.setStatus((short) 3);
        currentBooking.setCheckout(new Date());
        if (BookingDAOImpl.updateBooking(currentBooking)) {
            int index = 0;
            for (Room room : roomList3) {
                room.setStatus((short) 4);
                RoomDAOImpl.updateRoom(room);
                index = roomList.indexOf(room);
                roomList.remove(room);
                roomList.add(index, room);
            }
            for (BookingDetail bd : bookingDetailList2) {
                if (bd.getBooking().getId().equals(currentBooking.getId())) {
                    bd.setBooking(currentBooking);
                }
            }
            reloadRoomList = 1;
            reloadRevenueChart = 1;
            reloadRoomStatusChart = 1;
            bookingList.remove(currentBooking);
            bookingList.add(currentBooking);
            dialogBooking.setVisible(false);
            dialogBookingInfo.setVisible(false);
            lbSuccessTitle.setText("Thành công");
            lbSuccessTitleDetail.setText("Xử lí thành công");
            lbSuccess.setText("Đã Xử lí thành công.");
            dialogSuccess.setLocationRelativeTo(bg);
            mainOverLay.setVisible(true);
            dialogSuccess.setVisible(true);
            mainOverLay.setVisible(false);
            createBookingList(null, null, 2);
            displayBookingList(bookingListDisplay, tblUsing, false);
        }
    }//GEN-LAST:event_btnBookingActionActionPerformed

    private void tblPreBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPreBookMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblPreBook.getSelectedRow();
            String id = (tblPreBook.getValueAt(row, 1) + "").trim();
            currentBooking = BookingDAOImpl.getBookingById(id);
            currentBookingDetailList = BookingDetailDAOImpl.getBookingDetailsByBookingId(id);
            setupDialogBookingInfo(currentBooking, false);
            dialogBookingInfo.setLocationRelativeTo(bg);
            mainOverLay.setVisible(true);
            dialogBookingInfo.setVisible(true);
            if (!dialogBookingInfo.isVisible()) {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_tblPreBookMouseClicked

    private void btnGetRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRoomActionPerformed
        Date now = new Date();
        long diff = now.getTime() - currentBooking.getCheckin().getTime();
        float diffDays = ((float) diff) / (24 * 60 * 60 * 1000);
        if (diffDays < 0) {
            currentBooking.setCheckin(now);
        }
        currentBooking.setStatus((short) 2);
        currentBooking.setCheckout(currentBooking.getCheckin());
        if (BookingDAOImpl.updateBooking(currentBooking)) {
            int index = 0;
            for (Room r : roomList3) {
                r.setStatus((short) 2);
                RoomDAOImpl.updateRoom(r);
                index = roomList.indexOf(r);
                roomList.remove(r);
                roomList.add(index, r);
            }
            reloadRoomStatusChart = 1;
            reloadRoomList = 1;
            lbSuccessTitle.setText("Thành công");
            lbSuccessTitleDetail.setText("Xử lí thành công");
            lbSuccess.setText("Đã Xử lí thành công.");
            dialogSuccess.setLocationRelativeTo(dialogBookingInfo);
            bookingInfoOverlay.setVisible(true);
            dialogSuccess.setVisible(true);
            bookingInfoOverlay.setVisible(false);
            bookingList.remove(currentBooking);
            bookingList.add(currentBooking);
            createBookingList(null, null, 1);
            displayBookingList(bookingListDisplay, tblPreBook, false);
            dialogBookingInfo.setVisible(false);
        }
    }//GEN-LAST:event_btnGetRoomActionPerformed

    private void tblBookingHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingHistoryMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblBookingHistory.getSelectedRow();
            String id = (tblBookingHistory.getValueAt(row, 1) + "").trim();
            currentBooking = BookingDAOImpl.getBookingById(id);
            currentBookingDetailList = BookingDetailDAOImpl.getBookingDetailsByBookingId(id);
            setupDialogBooking(currentBooking, true);
            dialogBooking.setLocationRelativeTo(bg);
            mainOverLay.setVisible(true);
            dialogBooking.setVisible(true);
            if (!dialogBooking.isVisible()) {
                mainOverLay.setVisible(false);
            }
        }
    }//GEN-LAST:event_tblBookingHistoryMouseClicked

    private void btnBookService2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookService2ActionPerformed
        if (preSelectedRoom == null) {
            lbErrorTitle.setText("Lỗi");
            lbErrorTitleDetail.setText("Thông báo lỗi");
            lbError.setText("<html>Vui lòng chọn phòng muốn đặt dịch vụ!</html>");
            dialogError.setLocationRelativeTo(dialogBookService);
            bookServiceOverlay.setVisible(true);
            dialogError.setVisible(true);
            bookServiceOverlay.setVisible(false);
        } else {
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    BookingDetail bd = BookingDetailDAOImpl.getBookingDetailByRoomId(preSelectedRoom.getRoom().getId());
                    double servicePrice = 0;
                    int index = 0;
                    for (ServiceDetail sd : serviceDetailList) {
                        servicePrice += (sd.getAmount() * sd.getService().getPrice());
                        sd.setBookingDetail(bd);
                        ServiceDetailDAOImpl.insertServiceDetail(sd);
                        Service s = sd.getService();
                        s.setAmount(s.getAmount() - sd.getAmount());
                        ServiceDAOImpl.updateService(s);
                        index = serviceList.indexOf(s);
                        serviceList.remove(s);
                        serviceList.add(index, s);
                    }
                    bd.setServicePrice(servicePrice);
                    BookingDetailDAOImpl.updateBookingDetail(bd);
                    int in = bookingDetailList2.indexOf(bd);
                    if (in == -1) {
                        bookingDetailList2.add(bd);
                    } else {
                        Double oPrice = bookingDetailList2.get(in).getServicePrice();
                        bookingDetailList2.get(in).setServicePrice(oPrice + servicePrice);
                    }
                    lbSuccessTitle.setText("Thành công");
                    lbSuccessTitleDetail.setText("Đặt thành công");
                    lbSuccess.setText("Đã đặt dịch vụ thành công.");
                    dialogSuccess.setLocationRelativeTo(dialogBookService);
                    dialogLoadding.setVisible(false);
                    dialogSuccess.setVisible(true);
                    bookServiceOverlay.setVisible(false);
                    dialogBookService.setVisible(false);
                    mainOverLay.setVisible(false);
                    filterService();
                }
            };
            t1.start();
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    dialogLoadding.setLocationRelativeTo(dialogBookService);
                    bookServiceOverlay.setVisible(true);
                    dialogLoadding.setVisible(true);
                }
            };
            t2.start();
        }
    }//GEN-LAST:event_btnBookService2ActionPerformed

    private void btnOpenCard32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCard32ActionPerformed
        cardLayout3.show(pnlCards3, "pnlCard32");
    }//GEN-LAST:event_btnOpenCard32ActionPerformed

    private void txtSearchRoom3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchRoom3KeyReleased
        String keyword = txtSearchRoom3.getText().toLowerCase().trim();
        if (keyword.equals("")) {
            displayRoomList4(roomList4);
        } else {
            LinkedList<Room> l = new LinkedList<>();
            for (Room r : roomList4) {
                if (r.getName().toLowerCase().trim().contains(keyword)) {
                    l.add(r);
                }
            }
            displayRoomList4(l);
        }
    }//GEN-LAST:event_txtSearchRoom3KeyReleased

    private void deleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerActionPerformed
        lbWarningTitle.setText("Cảnh báo");
        lbWarningTitleDetail.setText("Cảnh báo xóa");
        lbWarning.setText("<html>Bạn có chắc chắn muốn xóa khách hàng này không?</html>");
        dialogWarning.setLocationRelativeTo(bg);
        mainOverLay.setVisible(true);
        dialogWarning.setVisible(true);
        int result = Integer.parseInt(lbWarningResult.getText());
        if (result == 1) {
            int row = tblCustomerList.getSelectedRow();
            String identityCard = (tblCustomerList.getValueAt(row, 1) + "").trim();
            Customer c = CustomerDAOImpl.getCustomerByIdentityCard(identityCard);
            if (CustomerDAOImpl.deleteCustomerById(c.getId())) {
                lbSuccessTitle.setText("Thành công");
                lbSuccessTitleDetail.setText("Xóa thành công");
                lbSuccess.setText("Đã xóa khách hàng thành công.");
                dialogSuccess.setLocationRelativeTo(bg);
                dialogSuccess.setVisible(true);
                mainOverLay.setVisible(false);
                customerList.remove(c);
                displayCustomerTable(customerList);
            } else {
                lbErrorTitle.setText("Lỗi");
                lbErrorTitleDetail.setText("Thông báo lỗi");
                lbError.setText("Không thể xóa khách hàng này!");
                dialogError.setLocationRelativeTo(bg);
                dialogError.setVisible(true);
                mainOverLay.setVisible(false);
            }
        } else {
            mainOverLay.setVisible(false);
        }
    }//GEN-LAST:event_deleteCustomerActionPerformed

    private void txtTypeNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypeNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveType();
        }
    }//GEN-LAST:event_txtTypeNameKeyPressed

    private void cbbAddRoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbAddRoomTypeActionPerformed
        txtAddRoom.requestFocus();
    }//GEN-LAST:event_cbbAddRoomTypeActionPerformed

    private void cbbAddRoomFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbAddRoomFloorActionPerformed
        txtAddRoom.requestFocus();
    }//GEN-LAST:event_cbbAddRoomFloorActionPerformed

    private void txtRoomNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRoomNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveRoom();
        }
    }//GEN-LAST:event_txtRoomNameKeyPressed

    private void txtAddRoomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddRoomKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveRoom();
        }
    }//GEN-LAST:event_txtAddRoomKeyPressed

    private void txtServiceNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServiceNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveService();
        }
    }//GEN-LAST:event_txtServiceNameKeyPressed

    private void txtCustomerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveCustomer();
        }
    }//GEN-LAST:event_txtCustomerNameKeyPressed

    private void txtCustomerEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveCustomer();
        }
    }//GEN-LAST:event_txtCustomerEmailKeyPressed

    private void rdMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaleActionPerformed
        txtAddCustomer.requestFocus();
    }//GEN-LAST:event_rdMaleActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        txtAddCustomer.requestFocus();
    }//GEN-LAST:event_rdFemaleActionPerformed

    private void txtAddCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddCustomerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleSaveCustomer();
        }
    }//GEN-LAST:event_txtAddCustomerKeyPressed

    private void dcCustomerBirthdayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcCustomerBirthdayPropertyChange
        txtAddCustomer.requestFocus();
    }//GEN-LAST:event_dcCustomerBirthdayPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel bg;
    private javax.swing.JPanel bookServiceOverlay;
    private javax.swing.JPanel bookingInfoOverlay;
    private keeptoo.KButton btnAddCustomer;
    private keeptoo.KButton btnAddRoom;
    private keeptoo.KButton btnAddService;
    private keeptoo.KButton btnAddType;
    private keeptoo.KButton btnBookRoom;
    private keeptoo.KButton btnBookService;
    private keeptoo.KButton btnBookService2;
    private keeptoo.KButton btnBookingAction;
    private keeptoo.KButton btnBookingRoom;
    private keeptoo.KButton btnBookingServiceNext1;
    private keeptoo.KButton btnCancelBook;
    private keeptoo.KButton btnCheckin;
    private keeptoo.KButton btnCloseDialogError;
    private keeptoo.KButton btnCloseDialogSuccess;
    private keeptoo.KButton btnCloseDialogWarning;
    private keeptoo.KButton btnFilterRoom;
    private keeptoo.KButton btnFilterRoom2;
    private keeptoo.KButton btnFilterService;
    private keeptoo.KButton btnGetRoom;
    private keeptoo.KButton btnMinus;
    private keeptoo.KButton btnOpenCard32;
    private keeptoo.KButton btnOpenPnlCard31;
    private keeptoo.KButton btnOpenPnlCard32;
    private keeptoo.KButton btnOpenPnlCard41;
    private keeptoo.KButton btnOpenPnlCard42;
    private keeptoo.KButton btnPay;
    private keeptoo.KButton btnPlus;
    private keeptoo.KButton btnResetAddType;
    private keeptoo.KButton btnResetBookingRoomList;
    private keeptoo.KButton btnResetBookingServiceList;
    private keeptoo.KButton btnSaveCustomer;
    private keeptoo.KButton btnSaveFloor;
    private keeptoo.KButton btnSaveRoom;
    private keeptoo.KButton btnSaveService;
    private keeptoo.KButton btnSaveType;
    private keeptoo.KButton btnSearchRoom;
    private keeptoo.KButton btnWarningAccept;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<Floor> cbbAddRoomFloor;
    private javax.swing.JComboBox<RoomType> cbbAddRoomType;
    private com.toedter.calendar.JMonthChooser cbbBookingHistoryMonth;
    private com.toedter.calendar.JYearChooser cbbBookingHistoryYear;
    private javax.swing.JComboBox<Floor> cbbFilterFloor;
    private javax.swing.JComboBox<RoomType> cbbFilterRoomType;
    private javax.swing.JComboBox<String> cbbFilterStatus;
    private javax.swing.JComboBox<Floor> cbbRoomFloor;
    private javax.swing.JComboBox<RoomType> cbbRoomType;
    private javax.swing.JComboBox<String> cbbServiceSort;
    private javax.swing.JComboBox<String> cbbServiceSort2;
    private javax.swing.JComboBox<String> cbbServiceStatus;
    private javax.swing.JCheckBoxMenuItem cleaning;
    private com.toedter.calendar.JDateChooser dcCustomerBirthday;
    private com.toedter.calendar.JDateChooser dcCustomerBirthday2;
    private javax.swing.JMenuItem deleteCustomer;
    private javax.swing.JMenuItem deleteRoomType1;
    private javax.swing.JMenuItem deleteService;
    private javax.swing.JDialog dialogAddCustomer;
    private javax.swing.JDialog dialogAddRoom;
    private javax.swing.JDialog dialogAddService;
    private javax.swing.JDialog dialogAddType;
    private javax.swing.JDialog dialogBookRoom;
    private javax.swing.JDialog dialogBookService;
    private javax.swing.JDialog dialogBooking;
    private javax.swing.JDialog dialogBookingDetail;
    private javax.swing.JDialog dialogBookingInfo;
    private javax.swing.JPanel dialogBookingOverLay;
    private javax.swing.JDialog dialogError;
    private javax.swing.JDialog dialogLoadding;
    private javax.swing.JDialog dialogSuccess;
    private javax.swing.JDialog dialogWarning;
    private javax.swing.JMenuItem editCustomer;
    private javax.swing.JMenuItem editRoomType1;
    private javax.swing.JMenuItem editService;
    private javax.swing.JMenuItem itemDelete;
    private javax.swing.JMenuItem itemEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane6;
    private keeptoo.KGradientPanel kGradientPanel14;
    private keeptoo.KGradientPanel kGradientPanel15;
    private keeptoo.KGradientPanel kGradientPanel17;
    private keeptoo.KGradientPanel kGradientPanel18;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel24;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private javax.swing.JLabel lbBookingDetaillTitle;
    private javax.swing.JLabel lbBookingDetaillTitle1;
    private javax.swing.JLabel lbBookingId;
    private javax.swing.JLabel lbBookingId2;
    private javax.swing.JLabel lbBookingUserId;
    private javax.swing.JLabel lbBookingUserName;
    private javax.swing.JLabel lbBookingUserRights;
    private javax.swing.JLabel lbCheckin2;
    private javax.swing.JLabel lbCloseAddCustomer;
    private javax.swing.JLabel lbCloseAddRoom;
    private javax.swing.JLabel lbCloseAddService;
    private javax.swing.JLabel lbCloseAddType;
    private javax.swing.JLabel lbCloseBookRoom;
    private javax.swing.JLabel lbCloseBookService;
    private javax.swing.JLabel lbCloseDialogBooking;
    private javax.swing.JLabel lbCloseDialogBookingDetaill;
    private javax.swing.JLabel lbCloseDialogBookingInfo;
    private javax.swing.JLabel lbCloseDialogError;
    private javax.swing.JLabel lbCloseDialogSuccess;
    private javax.swing.JLabel lbCloseDialogWarning;
    private javax.swing.JLabel lbCloseSetting;
    private javax.swing.JLabel lbCountDate;
    private javax.swing.JLabel lbCustomerBirthday;
    private javax.swing.JLabel lbCustomerEmail;
    private javax.swing.JLabel lbCustomerGender;
    private javax.swing.JLabel lbCustomerGender2;
    private javax.swing.JLabel lbCustomerId;
    private javax.swing.JLabel lbCustomerId2;
    private javax.swing.JLabel lbCustomerIdentityCard;
    private javax.swing.JLabel lbCustomerIdentityCard2;
    private javax.swing.JLabel lbCustomerName;
    private javax.swing.JLabel lbCustomerName2;
    private javax.swing.JLabel lbCustomerPhone;
    private javax.swing.JLabel lbCustomerPhone2;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbErrorAddCustomer;
    private javax.swing.JLabel lbErrorAddRoom;
    private javax.swing.JLabel lbErrorAddService;
    private javax.swing.JLabel lbErrorAddType;
    private javax.swing.JLabel lbErrorBasicSetting;
    private javax.swing.JLabel lbErrorCustomerInfo;
    private javax.swing.JLabel lbErrorTitle;
    private javax.swing.JLabel lbErrorTitleDetail;
    private javax.swing.JLabel lbNewCustomer;
    private javax.swing.JLabel lbOpenCard21;
    private javax.swing.JLabel lbOpenCard22;
    private javax.swing.JLabel lbOpenCard23;
    private javax.swing.JLabel lbPayDate;
    private javax.swing.JLabel lbPreFloor;
    private javax.swing.JLabel lbRights;
    private javax.swing.JLabel lbRoomCost;
    private javax.swing.JLabel lbRoomName;
    private javax.swing.JLabel lbRoomPrice;
    private javax.swing.JLabel lbRoomType;
    private javax.swing.JLabel lbSuccess;
    private javax.swing.JLabel lbSuccessTitle;
    private javax.swing.JLabel lbSuccessTitleDetail;
    private javax.swing.JLabel lbTitleAddCustomer;
    private javax.swing.JLabel lbTitleAddRoom;
    private javax.swing.JLabel lbTitleAddService;
    private javax.swing.JLabel lbTitleAddType;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotal2;
    private javax.swing.JLabel lbTypeId;
    private javax.swing.JLabel lbUserId2;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbUserName2;
    private javax.swing.JLabel lbUserRights2;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JLabel lbWarningResult;
    private javax.swing.JLabel lbWarningTitle;
    private javax.swing.JLabel lbWarningTitleDetail;
    private javax.swing.JPanel mainOverLay;
    private javax.swing.JPanel pnlBookingDetailHeader;
    private javax.swing.JPanel pnlBookingHeader;
    private javax.swing.JPanel pnlBookingInfoHeader;
    private javax.swing.JPanel pnlCard11;
    private javax.swing.JPanel pnlCard12;
    private javax.swing.JPanel pnlCard13;
    private javax.swing.JPanel pnlCard14;
    private javax.swing.JPanel pnlCard15;
    private javax.swing.JPanel pnlCard21;
    private javax.swing.JPanel pnlCard22;
    private javax.swing.JPanel pnlCard23;
    private javax.swing.JPanel pnlCard31;
    private javax.swing.JPanel pnlCard32;
    private javax.swing.JPanel pnlCard33;
    private javax.swing.JPanel pnlCard41;
    private javax.swing.JPanel pnlCard42;
    private javax.swing.JPanel pnlCards1;
    private javax.swing.JPanel pnlCards2;
    private javax.swing.JPanel pnlCards3;
    private javax.swing.JPanel pnlCards4;
    private javax.swing.JPanel pnlCards5;
    private javax.swing.JPanel pnlCloseWelcome;
    private javax.swing.JPanel pnlErrorHeader;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeaderAddCustomer;
    private javax.swing.JPanel pnlHeaderAddRoom;
    private javax.swing.JPanel pnlHeaderAddService;
    private javax.swing.JPanel pnlHeaderAddType;
    private javax.swing.JPanel pnlHeaderBookRoom;
    private javax.swing.JPanel pnlHeaderBookService;
    private javax.swing.JPanel pnlHeaderSetting;
    private javax.swing.JPanel pnlMinimizeWelcome;
    private javax.swing.JPanel pnlOpenPnlCard11;
    private javax.swing.JPanel pnlOpenPnlCard12;
    private javax.swing.JPanel pnlOpenPnlCard13;
    private javax.swing.JPanel pnlOpenPnlCard14;
    private javax.swing.JPanel pnlOpenPnlCard15;
    private javax.swing.JPanel pnlRoomList;
    private javax.swing.JPanel pnlRoomList2;
    private javax.swing.JPanel pnlRoomList3;
    private javax.swing.JPanel pnlRoomList4;
    private javax.swing.JPanel pnlServiceDetailList;
    private javax.swing.JPanel pnlServiceList;
    private javax.swing.JPanel pnlServiceList2;
    private javax.swing.JPanel pnlSetting;
    private javax.swing.JPanel pnlSignOut;
    private javax.swing.JPanel pnlSuccessHeader;
    private javax.swing.JPanel pnlWarningHeader;
    private javax.swing.JPopupMenu popupCustomer;
    private javax.swing.JPopupMenu popupRoomType1;
    private javax.swing.JPopupMenu popupService;
    private javax.swing.JPopupMenu popupTableType;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdFemale2;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JRadioButton rdMale2;
    private javax.swing.JPanel rightSideOverLay;
    private javax.swing.JDialog setting;
    private javax.swing.JPanel settingOverLay;
    private javax.swing.JScrollPane spnlBookingHistory;
    private javax.swing.JScrollPane spnlCustomerList;
    private javax.swing.JScrollPane spnlPreBook;
    private javax.swing.JScrollPane spnlRoomList;
    private javax.swing.JScrollPane spnlRoomList2;
    private javax.swing.JScrollPane spnlRoomList3;
    private javax.swing.JScrollPane spnlRoomList4;
    private javax.swing.JScrollPane spnlServiceDetailList;
    private javax.swing.JScrollPane spnlServiceList;
    private javax.swing.JScrollPane spnlServiceList2;
    private javax.swing.JScrollPane spnlTblBooking;
    private javax.swing.JScrollPane spnlTblBookingDetail;
    private javax.swing.JScrollPane spnlUsing;
    private javax.swing.JTable tblBooking;
    private javax.swing.JTable tblBookingDetail;
    private javax.swing.JTable tblBookingHistory;
    private javax.swing.JTable tblCustomerList;
    private javax.swing.JTable tblPreBook;
    private javax.swing.JTable tblRoomType;
    private javax.swing.JTable tblUsing;
    private javax.swing.JPanel test20;
    private javax.swing.JTextField txtAddCustomer;
    private javax.swing.JTextField txtAddRoom;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerEmail2;
    private javax.swing.JTextField txtCustomerIdentityCard;
    private javax.swing.JTextField txtCustomerIdentityCard2;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerName2;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtCustomerPhone2;
    private javax.swing.JTextField txtFloor;
    private javax.swing.JTextField txtHotelAddress;
    private javax.swing.JTextField txtHotelName;
    private javax.swing.JTextField txtRoomName;
    private javax.swing.JTextField txtSearchBooking3;
    private javax.swing.JTextField txtSearchBooking4;
    private javax.swing.JTextField txtSearchBooking5;
    private javax.swing.JTextField txtSearchCustomer;
    private javax.swing.JTextField txtSearchRoom;
    private javax.swing.JTextField txtSearchRoom2;
    private javax.swing.JTextField txtSearchRoom3;
    private javax.swing.JTextField txtSearchService;
    private javax.swing.JTextField txtSearchService2;
    private javax.swing.JTextField txtServiceAmount;
    private javax.swing.JTextField txtServiceName;
    private javax.swing.JTextField txtServicePrice;
    private javax.swing.JTextField txtTypeName;
    private javax.swing.JTextField txtTypePrice;
    // End of variables declaration//GEN-END:variables
}
