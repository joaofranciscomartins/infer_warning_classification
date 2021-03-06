/**
 * Copyright (c) 2005, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * Neither the name of the University of California, Los Angeles nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Creation date: Nov 22, 2005
 */

package edu.ucla.cs.compilers.avrora.avrora.arch.msp430.mcu;

import java.util.HashMap;

import edu.ucla.cs.compilers.avrora.avrora.arch.msp430.MSP430Interpreter;
import edu.ucla.cs.compilers.avrora.avrora.arch.msp430.MSP430Properties;
import edu.ucla.cs.compilers.avrora.avrora.core.Program;
import edu.ucla.cs.compilers.avrora.avrora.sim.Interpreter;
import edu.ucla.cs.compilers.avrora.avrora.sim.Simulation;
import edu.ucla.cs.compilers.avrora.avrora.sim.clock.ClockDomain;
import edu.ucla.cs.compilers.avrora.avrora.sim.mcu.DefaultMCU;
import edu.ucla.cs.compilers.avrora.avrora.sim.mcu.MCUProperties;
import edu.ucla.cs.compilers.avrora.avrora.sim.mcu.Microcontroller;
import edu.ucla.cs.compilers.avrora.avrora.sim.mcu.RegisterLayout;

/**
 * @author Ben L. Titzer
 */
public class F1611 extends DefaultMCU
{

    protected static final int IOREG_SIZE = 512;
    protected static final int _1kb = 1024;
    protected static final int SRAM_SIZE = 10 * _1kb;
    protected static final int CODE_START = 16 * _1kb;

    protected static final MSP430Properties PROPS = initProps();


    static MSP430Properties initProps()
    {
        HashMap<String, Integer> pins = new HashMap<String, Integer>();
        RegisterLayout layout = new RegisterLayout(IOREG_SIZE, 16);
        HashMap<String, Integer> ints = new HashMap<String, Integer>();
        return new MSP430Properties(IOREG_SIZE, SRAM_SIZE, CODE_START, 40, 64,
                pins, layout, ints);
    }

    protected final Interpreter interpreter;


    public F1611(int id, Simulation sim, ClockDomain cd, Program p)
    {
        super(cd, 60, PROPS.getRegisterLayout().instantiate(), null);
        simulator = sim.createSimulator(id, MSP430Interpreter.FACTORY, this, p);
        interpreter = simulator.getInterpreter();
    }


    @Override
    public void sleep()
    {
        // do nothing.
    }


    @Override
    public int wakeup()
    {
        return 0;
    }


    @Override
    public Microcontroller.Pin getPin(String n)
    {
        return getPin(PROPS.getPin(n));
    }


    @Override
    public MCUProperties getProperties()
    {
        return PROPS;
    }
}
