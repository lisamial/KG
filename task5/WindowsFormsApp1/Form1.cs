using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Task5;


namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        private Painter painter;
        private Sprites sprites;
        private Bitmap bitmap;
        private BubbleSort sort;
        private Graphics gBitmap, gScreen;
        public Form1()
        {
            InitializeComponent();
            gBitmap = panel1.CreateGraphics();
            button2.Enabled = false;

            painter = new Painter(pictureBox1);
            sprites = new Sprites();
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            sort = new BubbleSort(bitmap, gScreen, gBitmap, ClientRectangle);
            sort.Drawing(-1, -1);
            button1.Enabled = false;
            button2.Enabled = true;
        }

        private async void async_Button1_Click(object sender, EventArgs e)
        {
            button1.Enabled = false;
            button2.Enabled = false; 
            await  Task.Run(() => button2_Click(sender, e));
            button2.Enabled = true;
            button1.Enabled = true;

        }

        private void button2_Click(object sender, EventArgs e)
        {
            sort.Sort();
          
            timer1.Enabled = true;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            gScreen = panel1.CreateGraphics();
            bitmap = new Bitmap(panel1.Width, panel1.Height);
            gBitmap = Graphics.FromImage(bitmap);

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            pictureBox1.Refresh();
            pictureBox1.Invalidate();
            pictureBox1.BackgroundImage = painter.Paint();
        }

    }
}
